package com.amperly.Amperly.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amperly.Amperly.entity.MasterTariff;

@Repository
public interface MasterTariffRepo extends JpaRepository<MasterTariff, Long> {

    // Ek state ke saare slabs ko fetch krne ke liye
    List<MasterTariff> findByStateNameIgnoreCase(String stateName);

    List<MasterTariff> findByStateNameIgnoreCaseAndSlabMinLessThanEqualAndSlabMaxGreaterThanEqual(String stateName,
            Integer units, Integer units2);

}
