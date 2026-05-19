package com.assessment.smartpark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.smartpark.model.record.ParkingLotParkedVehicleListDto;
import com.assessment.smartpark.model.record.ParkingLotRecord;
import com.assessment.smartpark.model.record.RegisterParkingLotListDto;
import com.assessment.smartpark.model.record.RegisterParkingRequest;
import com.assessment.smartpark.model.record.RegisterParkingResponseDto;
import com.assessment.smartpark.model.record.VehicleRecord;
import com.assessment.smartpark.model.table.ParkingLot;
import com.assessment.smartpark.service.ParkingLotService;
import com.assessment.smartpark.service.util.HttpUtil;

@RestController
public class ParkingLotController extends BaseController {

    public ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/parking/register")
    public ResponseEntity<RegisterParkingResponseDto> registerParkingLot(@RequestBody RegisterParkingRequest request){
        var newParking = parkingLotService.registerNewParkingLot(request);
        return HttpUtil.generateCreatedResponseEntity(new RegisterParkingResponseDto(newParking));
    }

    @GetMapping("/parking/lots")
    public ResponseEntity<RegisterParkingLotListDto> fetchAllParkingLots(){
        List<ParkingLot> parkingLots = parkingLotService.getAllParkingLots();
        return HttpUtil.generateOKResponseEntity(new RegisterParkingLotListDto(parkingLots.stream().map(ParkingLotRecord::new).toList()));
    }

    @GetMapping("/parking/{lotId}/available")
    public ResponseEntity<RegisterParkingResponseDto> fetchAvailability(@PathVariable(required = true) String lotId){
            System.out.println("lotID : " + lotId);
            var parkingLot = parkingLotService.getParkingAvailability(lotId);
            return HttpUtil.generateOKResponseEntity(new RegisterParkingResponseDto(parkingLot));
    }

    @GetMapping("/parking/{lotId}/parked")
    public ResponseEntity<ParkingLotParkedVehicleListDto> fetchVehicleParked(@PathVariable(required = true) String lotId){
            List<VehicleRecord> parkedVehicleList = parkingLotService.getParkedVehicles(lotId);
            return HttpUtil.generateOKResponseEntity(new ParkingLotParkedVehicleListDto(parkedVehicleList));
    }
    
}
