package com.inventory.application.services;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.domain.dtos.EquipmentRequest;
import com.inventory.domain.models.Equipment;

import java.math.BigDecimal;
import java.util.List;

public interface EquipmentService {
    Equipment registerEquipment(EquipmentRequest equipmentRequest);
    Equipment updateEquipment(EquipmentRequest equipmentRequest, Long equipmentId) throws JsonMappingException;
    void deleteEquipment(Long equipmentId);
    Equipment getEquipment(Long equipmentId);
    List<Equipment> getAllEquipment();
    BigDecimal calculateDepreciation(Equipment equipment);
}
