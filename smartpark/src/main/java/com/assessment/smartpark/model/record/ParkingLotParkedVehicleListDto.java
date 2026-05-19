package com.assessment.smartpark.model.record;

import java.util.List;

import com.assessment.smartpark.model.dto.BaseResponseDto;

public class ParkingLotParkedVehicleListDto extends BaseResponseDto{
    List<VehicleRecord> parkedVehicle;

    public ParkingLotParkedVehicleListDto(List<VehicleRecord> parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public List<VehicleRecord> getParkedVehicles() {
        return parkedVehicle;
    }

    public void setParkedVehicles(List<VehicleRecord> parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }
}
