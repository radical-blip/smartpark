package com.assessment.smartpark.model.table;

import com.assessment.smartpark.model.enums.VehicleTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Vehicle extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    VehicleTypeEnum vehicleType;
    String ownerName;
    boolean isParked;

    public Vehicle(){
        super();
    }

    public Vehicle(String id, VehicleTypeEnum vehicleType, String ownerName) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        this.isParked = false;
    }

    public VehicleTypeEnum getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypeEnum vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean isParked) {
        this.isParked = isParked;
    }

}
