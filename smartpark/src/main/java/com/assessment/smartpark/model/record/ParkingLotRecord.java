package com.assessment.smartpark.model.record;

import com.assessment.smartpark.model.table.ParkingLot;

public record ParkingLotRecord(String lotId, String location, int capacity, int occupiedSpaces) {
        public ParkingLotRecord(ParkingLot parkingLot){
this(parkingLot.getId(), parkingLot.getLocation(), parkingLot.getCapacity(), parkingLot.getOccupied());
        }
}