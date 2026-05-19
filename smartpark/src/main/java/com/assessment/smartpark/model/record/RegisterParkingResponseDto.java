package com.assessment.smartpark.model.record;

import com.assessment.smartpark.model.dto.BaseResponseDto;
import com.assessment.smartpark.model.table.ParkingLot;

public class RegisterParkingResponseDto extends BaseResponseDto{
    String lotId;
    String location;
    int capacity;
    int occupiedSpaces;

    public RegisterParkingResponseDto(String lotId, String location, int capacity, int occupiedSpaces) {
        this.lotId = lotId;
        this.location = location;
        this.capacity = capacity;
        this.occupiedSpaces = occupiedSpaces;
    }

    public RegisterParkingResponseDto(ParkingLot parkingLot) {
        this.lotId = parkingLot.getId();
        this.location = parkingLot.getLocation();
        this.capacity = parkingLot.getCapacity();
        this.occupiedSpaces = parkingLot.getOccupied();
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupiedSpaces() {
        return occupiedSpaces;
    }

    public void setOccupiedSpaces(int occupiedSpaces) {
        this.occupiedSpaces = occupiedSpaces;
    }

}
