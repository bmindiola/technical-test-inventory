package com.inventory.application.mappers;

import com.inventory.domain.models.Equipment;
import com.inventory.infrastructure.entities.EquipmentEntity;


import java.util.List;


public interface EquipmentMapper {
    EquipmentEntity toEntity(Equipment equipment);
    List<EquipmentEntity> toEntityList(List<Equipment> equipmentList);
    Equipment toModel(EquipmentEntity equipmentEntity);
    List<Equipment> toModelList(List<EquipmentEntity> equipmentEntityList);
}
