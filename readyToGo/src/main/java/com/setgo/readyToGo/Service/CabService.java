package com.setgo.readyToGo.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setgo.readyToGo.DTO.Request.CabRequest;
import com.setgo.readyToGo.DTO.Response.CabResponse;
import com.setgo.readyToGo.DTO.Response.CabResponseForDriver;
import com.setgo.readyToGo.Model.Cab;
import com.setgo.readyToGo.Model.Driver;
import com.setgo.readyToGo.Exception.CabNotFoundException;
import com.setgo.readyToGo.Exception.DriverNotFoundException;
import com.setgo.readyToGo.Repository.CabRepository;
import com.setgo.readyToGo.Repository.DriverRepository;
import com.setgo.readyToGo.Transformer.CabTransformer;

@Service
public class CabService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CabRepository cabRepository;
    public CabResponse registerCab(CabRequest cabRequest, int driverId){
        Optional<Driver>optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Driver not found with id: " + driverId);
        }
        Driver driver=optionalDriver.get();
        Cab cab=CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);
        return CabTransformer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }

    public List<CabResponseForDriver>availableCabs(){
        List<Cab>availableCabs=cabRepository.findAllAvailableCabs();
        if(availableCabs.isEmpty()){
            throw new CabNotFoundException("No Cabs Available");
        }

        List<CabResponseForDriver>cabResponse=new ArrayList<>();
        
        for(Cab cab:availableCabs){
            cabResponse.add(CabTransformer.cabToCabResponseForDriver(cab));
        }
        return cabResponse;
    }
}
