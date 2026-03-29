package com.amperly.Amperly.dto;

import lombok.Data;

@Data
public class TariffRequest {

    private String stateName;
    private Integer slabMin;
    private Integer slabMax;
    private Double ratePerUnit;

}
