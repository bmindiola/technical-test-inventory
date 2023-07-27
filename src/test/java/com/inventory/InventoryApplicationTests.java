package com.inventory;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.application.services.EquipmentService;
import com.inventory.application.services.EquipmentServiceImpl;
import com.inventory.domain.dtos.EquipmentRequest;
import com.inventory.domain.models.Equipment;
import com.inventory.domain.ports.EquipmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class InventoryApplicationTests {
	@InjectMocks
	private EquipmentServiceImpl equipmentService;

	@Mock
	private EquipmentRepository equipmentRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testRegisterEquipment() {
		EquipmentRequest equipmentRequest = new EquipmentRequest();
		equipmentRequest.setName("Equipment 1");
		equipmentRequest.setDescription("Description 1");
		equipmentRequest.setSerialNumber("SN12345");
		equipmentRequest.setPurchaseDate(LocalDate.of(2020, 1, 1));
		equipmentRequest.setPurchaseValue(BigDecimal.valueOf(1000));

		Equipment equipment = new Equipment();
		equipment.setName("Equipment 1");
		equipment.setDescription("Description 1");
		equipment.setSerialNumber("SN12345");
		equipment.setPurchaseDate(LocalDate.of(2020, 1, 1));
		equipment.setPurchaseValue(BigDecimal.valueOf(1000));

		when(equipmentRepository.saveEquipment(Mockito.any(Equipment.class))).thenReturn(equipment);

		Equipment result = equipmentService.registerEquipment(equipmentRequest);

		verify(equipmentRepository).saveEquipment(Mockito.any(Equipment.class));
		assertEquals(equipment.getName(), result.getName());
		assertEquals(equipment.getDescription(), result.getDescription());
		assertEquals(equipment.getSerialNumber(), result.getSerialNumber());
		assertEquals(equipment.getPurchaseDate(), result.getPurchaseDate());
		assertEquals(equipment.getPurchaseValue(), result.getPurchaseValue());
	}

	@Test
	void testUpdateEquipment_ValidId() {
		Long equipmentId = 1L;
		EquipmentRequest equipmentRequest = new EquipmentRequest();
		equipmentRequest.setName("Updated Equipment");
		equipmentRequest.setDescription("Updated Description");
		equipmentRequest.setPurchaseDate(LocalDate.of(2022, 1, 1));
		equipmentRequest.setPurchaseValue(BigDecimal.valueOf(1500));

		Equipment existingEquipment = new Equipment();
		existingEquipment.setName("Equipment 1");
		existingEquipment.setDescription("Description 1");
		existingEquipment.setSerialNumber("SN12345");
		existingEquipment.setPurchaseDate(LocalDate.of(2020, 1, 1));
		existingEquipment.setPurchaseValue(BigDecimal.valueOf(1000));

		when(equipmentRepository.findEquipmentById(equipmentId)).thenReturn(existingEquipment);
		when(equipmentRepository.updateEquipment(Mockito.any(Equipment.class), Mockito.eq(equipmentId))).thenReturn(existingEquipment);

		Equipment result = equipmentService.updateEquipment(equipmentRequest, equipmentId);

		verify(equipmentRepository).findEquipmentById(equipmentId);
		verify(equipmentRepository).updateEquipment(Mockito.any(Equipment.class), Mockito.eq(equipmentId));
		assertEquals(equipmentRequest.getName(), result.getName());
		assertEquals(equipmentRequest.getDescription(), result.getDescription());
		assertEquals(existingEquipment.getSerialNumber(), result.getSerialNumber());
		assertEquals(equipmentRequest.getPurchaseDate(), result.getPurchaseDate());
		assertEquals(equipmentRequest.getPurchaseValue(), result.getPurchaseValue());
	}

	@Test
	void testUpdateEquipment_InvalidId() {
		Long equipmentId = 1L;
		EquipmentRequest equipmentRequest = new EquipmentRequest();

		when(equipmentRepository.findEquipmentById(equipmentId)).thenReturn(null);

		Equipment result = equipmentService.updateEquipment(equipmentRequest, equipmentId);

		verify(equipmentRepository).findEquipmentById(equipmentId);
		assertNull(result);
	}

	@Test
	public void testGetEquipment_ValidId() {
		Long equipmentId = 1L;
		Equipment equipment = new Equipment();
		equipment.setName("Equipment 1");

		when(equipmentRepository.findEquipmentById(equipmentId)).thenReturn(equipment);

		Equipment result = equipmentService.getEquipment(equipmentId);

		verify(equipmentRepository).findEquipmentById(equipmentId);
		assertEquals(equipment.getName(), result.getName());
	}


	@Test
	void testDeleteEquipment() {
		Long equipmentId = 1L;

		equipmentService.deleteEquipment(equipmentId);

		verify(equipmentRepository).deleteEquipment(equipmentId);
	}

	@Test
	void testGetEquipment_InvalidId() {
		Long equipmentId = 1L;

		when(equipmentRepository.findEquipmentById(equipmentId)).thenReturn(null);

		Equipment result = equipmentService.getEquipment(equipmentId);

		verify(equipmentRepository).findEquipmentById(equipmentId);
		assertNull(result);
	}

	@Test
	void testGetAllEquipment() {
		List<Equipment> equipmentList = new ArrayList<>();

		when(equipmentRepository.findAllEquipment()).thenReturn(equipmentList);

		List<Equipment> result = equipmentService.getAllEquipment();

		verify(equipmentRepository).findAllEquipment();
		assertEquals(equipmentList.size(), result.size());
	}
}
