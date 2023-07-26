package com.inventory.infrastructure.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.application.services.EquipmentServiceImpl;
import com.inventory.domain.dtos.EquipmentRequest;
import com.inventory.domain.models.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentServiceImpl equipmentService;

    @PostMapping
    public ResponseEntity<Equipment> createEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        Equipment equipmentCreated = equipmentService.registerEquipment(equipmentRequest);
        return new ResponseEntity<>(equipmentCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{equipmentId}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable Long equipmentId, @RequestBody EquipmentRequest equipmentRequest) throws JsonMappingException {
        Equipment equipmentUpdated = equipmentService.updateEquipment(equipmentRequest, equipmentId);
        return new ResponseEntity<>(equipmentUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Long equipmentId) {
        Equipment equipment = equipmentService.getEquipment(equipmentId);
        if (equipment != null) {
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipments = equipmentService.getAllEquipment();
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }
}
