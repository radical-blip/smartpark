package com.assessment.smartpark.model.record;

import java.util.List;

import com.assessment.smartpark.model.dto.BaseResponseDto;

public class RegisterParkingLotListDto extends BaseResponseDto{
    List<ParkingLotRecord> parkingLots;

    public RegisterParkingLotListDto(List<ParkingLotRecord> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLotRecord> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLotRecord> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
