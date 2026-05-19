package com.assessment.smartpark.model.table;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class ParkingLot extends BaseEntity{

    String location;
    int capacity;
    int occupied;
    @JoinColumn
    @OneToMany(fetch = FetchType.LAZY)
    Set<Vehicle> parked;

    public ParkingLot(){
        super();
        this.occupied = 0;
    }

    public ParkingLot(String id, String location, int capacity) {
        super();
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.occupied = 0;
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

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Set<Vehicle> getParked() {
        return parked;
    }

    public void setParked(Set<Vehicle> parked) {
        this.parked = parked;
    }

    public boolean validateIfFull(){
        return (occupied >= capacity);
    }

    public void checkIn(Vehicle vehicle){
        this.capacity = this.capacity - 1;
        this.occupied = this.occupied + 1;
        this.parked.add(vehicle);
    }

    public void checkOut(Vehicle vehicle){
        this.capacity = this.capacity + 1;
        this.occupied = this.occupied - 1;
        this.parked.remove(vehicle);
    }

}
