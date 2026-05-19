package com.assessment.smartpark;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assessment.smartpark.service.ParkingLotService;
import com.assessment.smartpark.service.VehicleService;
import com.assessment.smartpark.service.exceptions.NoRollbackException;

@SpringBootTest
class SmartparkApplicationTests {
	@Mock
	@Autowired
	VehicleService vehicleService;
	@Mock
	@Autowired
	ParkingLotService parkingLotService;

	@Test
	@DisplayName("Should return true when license plate is acceptable.")
	void validateLicenseSuccess() {
		assertTrue(vehicleService.validateLicensePlate("NEW782"));
	}

	@Test
	@DisplayName("Should throw Exception when license plate is not acceptable.")
	void validateLicenseThrowInvalidFormat() {
		assertThrows(NoRollbackException.class, () -> {
			vehicleService.validateLicensePlate("NCK 782");
		});
	}

	@Test
	@DisplayName("Should throw Exception when license plate is already registered.")
	void validateLicenseThrowInvalidLicensePlate() {
		assertThrows(NoRollbackException.class, () -> {
			vehicleService.validateLicensePlate("NCK782");
		});
	}

	@Test
	@DisplayName("Should return TRUE when license plate is already registered.")
	void validateLicenseShouldExist() {
		assertTrue(vehicleService.isLicensePlateRegistered("NCK782"));
	}

	@Test
	@DisplayName("Should return FALSE when license plate is not yet registered.")
	void validateLicenseShouldNotExist() {
		assertFalse(vehicleService.isLicensePlateRegistered("FakeNCK782"));
	}

	@Test
	@DisplayName("Should return FALSE when parking lot id is not yet registered.")
	void validateLotIdShouldNotExist() {
		assertFalse(parkingLotService.doesParkingLotExist("FakeLotId"));
	}

	@Test
	@DisplayName("Should throw an exception when parking lot id is not yet registered.")
	void validateLotIdShouldThrowException() {
		assertThrows(NoRollbackException.class, () -> {
			parkingLotService.getParkingAvailability("FakeLotId");
		});
	}
}
