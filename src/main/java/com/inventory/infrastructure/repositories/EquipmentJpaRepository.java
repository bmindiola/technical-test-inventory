package com.inventory.infrastructure.repositories;

import com.inventory.infrastructure.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentJpaRepository extends JpaRepository<EquipmentEntity, Long> {
}
