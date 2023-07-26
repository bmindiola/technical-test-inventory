package com.inventory.domain.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EquipmentRequest {
    private String serialNumber;
    private String description;
    private String name;
    private LocalDate purchaseDate;
    private BigDecimal purchaseValue;
}
