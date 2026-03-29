package com.amperly.Amperly.service;

import java.util.List;

import com.amperly.Amperly.dto.TariffRequest;
import com.amperly.Amperly.dto.TariffResponse;

public interface TariffService {

    TariffResponse addTariff(TariffRequest request);

    List<TariffResponse> getTariffsByState(String stateName);

    Double getRateForUnits(String statename, Integer units);

}
