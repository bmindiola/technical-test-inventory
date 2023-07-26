package com.inventory.application.mappers;

import com.inventory.domain.models.Equipment;
import com.inventory.infrastructure.entities.EquipmentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipmentMapperImpl implements EquipmentMapper{
    @Override
    public EquipmentEntity toEntity(Equipment equipment) {
        return EquipmentEntity.builder()
                .serialNumber(equipment.getSerialNumber())
                .description(equipment.getDescription())
                .name(equipment.getName())
                .purchaseDate(equipment.getPurchaseDate())
                .purchaseValue(equipment.getPurchaseValue())
                .build();
    }

    @Override
    public List<EquipmentEntity> toEntityList(List<Equipment> equipmentList) {
        return equipmentList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Equipment toModel(EquipmentEntity equipmentEntity) {
        return Equipment.builder()
                .id(equipmentEntity.getId())
                .serialNumber(equipmentEntity.getSerialNumber())
                .description(equipmentEntity.getDescription())
                .name(equipmentEntity.getName())
                .purchaseDate(equipmentEntity.getPurchaseDate())
                .purchaseValue(equipmentEntity.getPurchaseValue())
                .build();
    }

    @Override
    public List<Equipment> toModelList(List<EquipmentEntity> equipmentEntityList) {
        return equipmentEntityList.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
