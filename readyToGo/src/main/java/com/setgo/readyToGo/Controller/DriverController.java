package com.setgo.readyToGo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setgo.readyToGo.DTO.Request.DriverRequest;
import com.setgo.readyToGo.DTO.Response.DriverResponse;
import com.setgo.readyToGo.Enum.Gender;
import com.setgo.readyToGo.Service.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/driver")

public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest){
        return new ResponseEntity<>(driverService.addDriver(driverRequest),HttpStatus.CREATED);
    }

    @GetMapping("/get/driverId/{driverId}")
    public ResponseEntity<DriverResponse> getDriverById(@PathVariable int driverId) {
        return new ResponseEntity<>(driverService.getDriverById(driverId), HttpStatus.OK);
    }

    @GetMapping("/get/driverNumber/{driverPhone}")
    public ResponseEntity<DriverResponse> getDriverByNumber(@PathVariable String phoneNo) {
        return new ResponseEntity<>(driverService.getDriverByNumber(phoneNo), HttpStatus.OK);
    }
    
    @GetMapping("/get/gender/{gender}")
    public ResponseEntity<List<DriverResponse>> getDriverByGender(@PathVariable Gender gender){
        return new ResponseEntity<>(driverService.getDriverByGender(gender),HttpStatus.OK);
    }

}
