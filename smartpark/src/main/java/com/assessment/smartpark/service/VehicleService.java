package com.assessment.smartpark.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.smartpark.model.enums.ResponseCodeEnum;
import com.assessment.smartpark.model.enums.VehicleTypeEnum;
import com.assessment.smartpark.model.record.MoveVehicleRequest;
import com.assessment.smartpark.model.record.RegisterVehicleRequest;
import com.assessment.smartpark.model.table.ParkingLot;
import com.assessment.smartpark.model.table.Vehicle;
import com.assessment.smartpark.repository.VehicleRepository;
import com.assessment.smartpark.service.exceptions.NoRollbackException;

@Service
public class VehicleService extends BaseService<Vehicle, VehicleRepository>{

    ParkingLotService parkingLotService;

    public VehicleService(){

    }

    @Autowired
    public VehicleService(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public Boolean validateLicensePlate(String licensePlate){
        if(licensePlate != null && licensePlate.matches("^[a-zA-Z0-9-]*$")){
            Optional<Vehicle> vehicleOptional = findOptionalById(licensePlate);
            if(vehicleOptional.isPresent()){
                throw new NoRollbackException(ResponseCodeEnum.INVALID_LICENSE_PLATE);
            }
            return true;
        }
        else{
            throw new NoRollbackException(ResponseCodeEnum.INVALID_PLATE_FORMAT);
        }
    }

    public List<Vehicle> getAllVehicles(){
        return repository.findAll();
    }

    public Vehicle registerVehicle(RegisterVehicleRequest request){
        validateLicensePlate(request.licensePlate());
        
        VehicleTypeEnum typeEnum = VehicleTypeEnum.valueOf(request.type());
        Vehicle newVehicle = new Vehicle(request.licensePlate(), typeEnum, request.ownerName());
        return repository.save(newVehicle);
    }

    public boolean isLicensePlateRegistered(String licensePlate){
        Optional<Vehicle> vehicleOptional = findOptionalById(licensePlate);
        if(vehicleOptional.isEmpty()){
            return false;
        }
        return true;
    }

    public ParkingLot checkInVehicle(MoveVehicleRequest request){
        ParkingLot parkingLot = parkingLotService.getParkingAvailability(request.lotId());
        if(parkingLot.validateIfFull()){
            throw new NoRollbackException(ResponseCodeEnum.LOT_ALREADY_FULL);
        }
        if(!isLicensePlateRegistered(request.licensePlate())){
            throw new NoRollbackException(ResponseCodeEnum.LICENSE_PLATE_NOT_REGISTERED);
        }
        Vehicle vehicle = findById(request.licensePlate());
        if(vehicle.isParked()){
            throw new NoRollbackException(ResponseCodeEnum.VEHICLE_ALREADY_PARKED);
        }
        vehicle.setParked(true);
        vehicle = repository.save(vehicle);
        
        parkingLot.checkIn(vehicle);
        parkingLot = parkingLotService.save(parkingLot);
        return parkingLot;
    }

    public ParkingLot checkOutVehicle(MoveVehicleRequest request){
        ParkingLot parkingLot = parkingLotService.getParkingAvailability(request.lotId());
        if(parkingLot.validateIfFull()){
            throw new NoRollbackException(ResponseCodeEnum.LOT_ALREADY_FULL);
        }
        if(!isLicensePlateRegistered(request.licensePlate())){
            throw new NoRollbackException(ResponseCodeEnum.LICENSE_PLATE_NOT_REGISTERED);
        }
        Vehicle vehicle = findById(request.licensePlate());
        if(!vehicle.isParked()){
            throw new NoRollbackException(ResponseCodeEnum.VEHICLE_NOT_YET_PARKED);
        }
        vehicle.setParked(false);
        vehicle = repository.save(vehicle);
        
        parkingLot.checkOut(vehicle);
        parkingLot = parkingLotService.save(parkingLot);
        return parkingLot;
    }


}
