package com.assessment.smartpark.model.record;

import com.assessment.smartpark.model.dto.BaseResponseDto;
import com.assessment.smartpark.model.enums.VehicleTypeEnum;
import com.assessment.smartpark.model.table.Vehicle;

public class RegisterVehicleResponseDto extends BaseResponseDto{
    String licensePlate;
    VehicleTypeEnum type;
    String ownerName;
    
    public RegisterVehicleResponseDto() {
        super();
    }

    public RegisterVehicleResponseDto(String licensePlate, VehicleTypeEnum type, String ownerName) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.ownerName = ownerName;
    }

    public RegisterVehicleResponseDto(Vehicle vehicle) {
        this.licensePlate = vehicle.getId();
        this.type = vehicle.getVehicleType();
        this.ownerName = vehicle.getOwnerName();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleTypeEnum getType() {
        return type;
    }

    public void setType(VehicleTypeEnum type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
