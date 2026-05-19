package com.assessment.smartpark.model.record;

import java.util.List;

import com.assessment.smartpark.model.dto.BaseResponseDto;

public class RegisteredVehicleListDto extends BaseResponseDto{
    List<VehicleRecord> registeredVehicle;

    public RegisteredVehicleListDto(List<VehicleRecord> registeredVehicle) {
        this.registeredVehicle = registeredVehicle;
    }

    public List<VehicleRecord> getRegisteredVehicles() {
        return registeredVehicle;
    }

    public void setRegisteredVehicles(List<VehicleRecord> registeredVehicle) {
        this.registeredVehicle = registeredVehicle;
    }
}
