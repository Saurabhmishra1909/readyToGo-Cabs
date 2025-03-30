package com.setgo.readyToGo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setgo.readyToGo.DTO.Request.CabRequest;
import com.setgo.readyToGo.DTO.Response.CabResponse;
import com.setgo.readyToGo.DTO.Response.CabResponseForDriver;
import com.setgo.readyToGo.Service.CabService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    CabService cabService;

    @PostMapping("/register/{driverId}")
    public ResponseEntity<CabResponse> registerCab(
        @RequestBody CabRequest cabRequest, 
        @PathVariable int driverId) {
        return new ResponseEntity<>(cabService.registerCab(cabRequest,driverId), HttpStatus.CREATED);
    }

    @GetMapping("/availableCabs")
    public ResponseEntity<List<CabResponseForDriver>>availableCabs(){
        return new ResponseEntity<>(cabService.availableCabs(),HttpStatus.OK);
    }
    
}
