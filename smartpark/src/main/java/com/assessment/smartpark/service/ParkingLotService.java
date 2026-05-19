package com.assessment.smartpark.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.assessment.smartpark.model.enums.ResponseCodeEnum;
import com.assessment.smartpark.model.record.RegisterParkingRequest;
import com.assessment.smartpark.model.record.VehicleRecord;
import com.assessment.smartpark.model.table.ParkingLot;
import com.assessment.smartpark.repository.ParkingLotRepository;
import com.assessment.smartpark.service.exceptions.NoRollbackException;

@Service
public class ParkingLotService extends BaseService<ParkingLot, ParkingLotRepository>{
    public ParkingLot registerNewParkingLot(RegisterParkingRequest request){
        String newUuid = UUID.randomUUID().toString();
        ParkingLot newParkingLot = new ParkingLot(newUuid, request.location(), request.capacity());

        return repository.save(newParkingLot);
    }

    public List<ParkingLot> getAllParkingLots(){
        return repository.findAll();
    }

    public boolean doesParkingLotExist(String lotId){
        Optional<ParkingLot> parkingOptional = findOptionalById(lotId);
        
        return parkingOptional.isPresent();
    }

    public ParkingLot getParkingAvailability(String lotId){
        if(!doesParkingLotExist(lotId)){
            throw new NoRollbackException(ResponseCodeEnum.INVALID_LOT_ID);
        }

        return findById(lotId);
    }

    public List<VehicleRecord> getParkedVehicles(String lotId){
        if(!doesParkingLotExist(lotId)){
            throw new NoRollbackException(ResponseCodeEnum.INVALID_LOT_ID);
        }
        ParkingLot parkingLot = findById(lotId);
        return parkingLot.getParked().stream().map(VehicleRecord::new).toList();
    }
    
}
