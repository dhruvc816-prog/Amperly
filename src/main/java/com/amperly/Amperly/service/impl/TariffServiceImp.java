package com.amperly.Amperly.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amperly.Amperly.dto.TariffRequest;
import com.amperly.Amperly.dto.TariffResponse;
import com.amperly.Amperly.entity.MasterTariff;
import com.amperly.Amperly.repo.MasterTariffRepo;
import com.amperly.Amperly.service.TariffService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TariffServiceImp implements TariffService {

    private final MasterTariffRepo tariffrepo;

    @Override
    public TariffResponse addTariff(TariffRequest request) {
        var tariff = MasterTariff.builder()
                .stateName(request.getStateName())
                .slabMin(request.getSlabMin())
                .slabMax(request.getSlabMax())
                .ratePerUnit(request.getRatePerUnit())
                .build();

        var saved = tariffrepo.save(tariff);
        return toResponse(saved);

    }

    @Override
    public List<TariffResponse> getTariffsByState(String stateName) {
        return tariffrepo.findByStateNameIgnoreCase(stateName)
                .stream().map(this::toResponse).toList();
    }

    @Override
    public Double getRateForUnits(String statename, Integer units) {

        return tariffrepo
                .findByStateNameIgnoreCaseAndSlabMinLessThanEqualAndSlabMaxGreaterThanEqual(statename, units, units)
                .stream()
                .findFirst()
                .map(MasterTariff::getRatePerUnit)
                .orElseThrow(() -> new RuntimeException(
                        "Tariff not found for state: " + statename + " and units: " + units));
    }

    private TariffResponse toResponse(MasterTariff t) {
        return new TariffResponse(t.getId(), t.getStateName(),
                t.getSlabMin(), t.getSlabMax(), t.getRatePerUnit());
    }

}
