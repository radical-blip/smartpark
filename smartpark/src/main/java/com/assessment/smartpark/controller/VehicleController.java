package com.assessment.smartpark.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.smartpark.model.dto.BaseResponseDto;
import com.assessment.smartpark.model.enums.ResponseCodeEnum;
import com.assessment.smartpark.model.record.MoveVehicleRequest;
import com.assessment.smartpark.model.record.ParkingLotRecord;
import com.assessment.smartpark.model.record.RegisterParkingLotListDto;
import com.assessment.smartpark.model.record.RegisterParkingResponseDto;
import com.assessment.smartpark.model.record.RegisterVehicleRequest;
import com.assessment.smartpark.model.record.RegisterVehicleResponseDto;
import com.assessment.smartpark.model.record.RegisteredVehicleListDto;
import com.assessment.smartpark.model.record.VehicleRecord;
import com.assessment.smartpark.model.table.ParkingLot;
import com.assessment.smartpark.model.table.Vehicle;
import com.assessment.smartpark.service.VehicleService;
import com.assessment.smartpark.service.util.HttpUtil;

@RestController
public class VehicleController extends BaseController {

    public VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle/register")
    public ResponseEntity<BaseResponseDto> registerVehicle(@RequestBody RegisterVehicleRequest request){
        try {
            var newVehicle = vehicleService.registerVehicle(request);
        return HttpUtil.generateCreatedResponseEntity(new RegisterVehicleResponseDto(newVehicle));
        } catch (IllegalArgumentException e) {
        return HttpUtil.generateErrorResponseEntity(new BaseResponseDto(ResponseCodeEnum.INVALID_VEHICLE_TYPE));
        }
    }

    @GetMapping("/vehicle/registered")
    public ResponseEntity<RegisteredVehicleListDto> fetchAllParkingLots(){
        List<Vehicle> registeredVehicles = vehicleService.getAllVehicles();
        return HttpUtil.generateOKResponseEntity(new RegisteredVehicleListDto(registeredVehicles.stream().map(VehicleRecord::new).toList()));
    }

    @PostMapping("/vehicle/check-in")
    public ResponseEntity<RegisterParkingResponseDto> checkInVehicle(@RequestBody MoveVehicleRequest request){
            var parkingLot = vehicleService.checkInVehicle(request);
            return HttpUtil.generateOKResponseEntity(new RegisterParkingResponseDto(parkingLot));
    }

    @PostMapping("/vehicle/check-out")
    public ResponseEntity<RegisterParkingResponseDto> checkOutVehicle(@RequestBody MoveVehicleRequest request){
            var parkingLot = vehicleService.checkOutVehicle(request);
            return HttpUtil.generateOKResponseEntity(new RegisterParkingResponseDto(parkingLot));
    }
    
}
