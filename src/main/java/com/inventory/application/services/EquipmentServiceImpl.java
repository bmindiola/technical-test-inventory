package com.inventory.application.services;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.domain.dtos.EquipmentRequest;
import com.inventory.domain.models.Equipment;
import com.inventory.domain.ports.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public Equipment registerEquipment(EquipmentRequest equipmentRequest) {
        Equipment equipment = Equipment.builder()
                    .name(equipmentRequest.getName())
                    .description(equipmentRequest.getDescription())
                    .serialNumber(equipmentRequest.getSerialNumber())
                    .purchaseDate(equipmentRequest.getPurchaseDate())
                    .purchaseValue(equipmentRequest.getPurchaseValue())
                    .build();
        equipment.setAccumulatedDepreciation(calculateDepreciation(equipment));
        return equipmentRepository.saveEquipment(equipment);
    }

    @Override
    public Equipment updateEquipment(EquipmentRequest equipmentRequest, Long equipmentId) throws JsonMappingException {
        Equipment existingEquipment = equipmentRepository.findEquipmentById(equipmentId);
        if (existingEquipment == null) return null;
        existingEquipment.setName(equipmentRequest.getName());
        existingEquipment.setDescription(equipmentRequest.getDescription());
        existingEquipment.setName(equipmentRequest.getName());
        existingEquipment.setPurchaseDate(equipmentRequest.getPurchaseDate());
        existingEquipment.setPurchaseValue(equipmentRequest.getPurchaseValue());
        return equipmentRepository.updateEquipment(existingEquipment, equipmentId);
    }

    @Override
    public void deleteEquipment(Long equipmentId) {
        equipmentRepository.deleteEquipment(equipmentId);
    }

    @Override
    public Equipment getEquipment(Long equipmentId) {
        Equipment equipment = equipmentRepository.findEquipmentById(equipmentId);
        if (equipment == null) return null;
        equipment.setAccumulatedDepreciation(calculateDepreciation(equipment));
        return equipment;
    }

    @Override
    public List<Equipment> getAllEquipment() {
        List<Equipment> equipmentList = equipmentRepository.findAllEquipment();
        if (equipmentList.isEmpty()) return Collections.emptyList();
        equipmentList.forEach(equipment -> {
            equipment.setAccumulatedDepreciation(calculateDepreciation(equipment));
        });
        return equipmentList;
    }

    @Override
    public BigDecimal calculateDepreciation(Equipment equipment) {
        LocalDate currentDate = LocalDate.now();
        LocalDate purchaseDate = equipment.getPurchaseDate();
        long yearsSincePurchase = ChronoUnit.YEARS.between(purchaseDate, currentDate);

        BigDecimal depreciationAnnual = new BigDecimal("0.04");
        BigDecimal one = new BigDecimal("1");
        BigDecimal depreciationPercentage = depreciationAnnual.multiply(BigDecimal.valueOf(yearsSincePurchase));
        BigDecimal depreciationFactor = one.subtract(depreciationPercentage);

        BigDecimal depreciatedValue = equipment.getPurchaseValue().multiply(depreciationFactor);
        return depreciatedValue.setScale(2, RoundingMode.HALF_UP);
    }
}
