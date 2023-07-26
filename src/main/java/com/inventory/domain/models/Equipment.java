package com.inventory.domain.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Equipment {
    private Long id;
    private String serialNumber;
    private String description;
    private String name;
    private LocalDate purchaseDate;
    private BigDecimal purchaseValue;
    private BigDecimal accumulatedDepreciation;
}
