package com.inventory.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Equipment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String description;
    private String name;
    private LocalDate purchaseDate;
    private BigDecimal purchaseValue;
}
