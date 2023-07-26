package com.inventory.domain.ports;

import com.inventory.domain.dtos.EquipmentRequest;
import com.inventory.domain.models.Equipment;

import java.util.List;

public interface EquipmentRepository {
    Equipment saveEquipment(Equipment equipment);
    Equipment updateEquipment(Equipment equipment, Long equipmentId);
    void deleteEquipment(Long equipmentId);
    Equipment findEquipmentById(Long equipmentId);
    List<Equipment> findAllEquipment();
}
