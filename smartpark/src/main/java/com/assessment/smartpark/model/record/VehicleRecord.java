package com.assessment.smartpark.model.record;

import com.assessment.smartpark.model.enums.VehicleTypeEnum;
import com.assessment.smartpark.model.table.Vehicle;

public record VehicleRecord(String licensePlate, VehicleTypeEnum vehicleType, String ownerName) {
        public VehicleRecord(Vehicle vehicle){
                this(vehicle.getId(), vehicle.getVehicleType(), vehicle.getOwnerName());
        }
}