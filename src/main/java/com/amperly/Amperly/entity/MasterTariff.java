package com.amperly.Amperly.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "master_tariffs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterTariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String stateName;

    @Column
    private Integer slabMin;

    @Column
    private Integer slabMax;

    @Column
    private Double ratePerUnit;

}
