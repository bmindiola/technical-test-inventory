package com.inventory.infrastructure.adapters;

import com.inventory.application.mappers.EquipmentMapper;
import com.inventory.domain.models.Equipment;
import com.inventory.domain.ports.EquipmentRepository;
import com.inventory.infrastructure.entities.EquipmentEntity;
import com.inventory.infrastructure.repositories.EquipmentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EquipmentRepositoryImpl implements EquipmentRepository {
    @Autowired
    EquipmentJpaRepository equipmentJpaRepository;
    @Autowired
    EquipmentMapper equipmentMapper;

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        EquipmentEntity equipmentEntity = equipmentMapper.toEntity(equipment);
        return equipmentMapper.toModel(equipmentJpaRepository.save(equipmentEntity));
    }

    @Override
    public Equipment updateEquipment(Equipment equipment, Long equipmentId) {
        EquipmentEntity equipmentEntity = equipmentMapper.toEntity(equipment);
        equipmentEntity.setId(equipmentId);
        return equipmentMapper.toModel(equipmentJpaRepository.save(equipmentEntity));
    }

    @Override
    public void deleteEquipment(Long equipmentId) {
        equipmentJpaRepository.deleteById(equipmentId);
    }

    @Override
    public Equipment findEquipmentById(Long equipmentId) {
        Optional<EquipmentEntity> equipmentEntityOptional = equipmentJpaRepository.findById(equipmentId);
        if (equipmentEntityOptional.isEmpty()) return null;
        return equipmentMapper.toModel(equipmentEntityOptional.get());
    }

    @Override
    public List<Equipment> findAllEquipment() {
        return equipmentMapper.toModelList(equipmentJpaRepository.findAll());
    }
}
