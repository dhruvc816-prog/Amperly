package com.amperly.Amperly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TariffResponse {

    private Long id;
    private String stateName;
    private Integer slabMin;
    private Integer slabMax;
    private Double ratePerUnit;

}
