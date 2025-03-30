package com.setgo.readyToGo.Transformer;

import com.setgo.readyToGo.DTO.Request.CabRequest;
import com.setgo.readyToGo.DTO.Response.CabResponse;
import com.setgo.readyToGo.DTO.Response.CabResponseForDriver;
import com.setgo.readyToGo.Model.Cab;
import com.setgo.readyToGo.Model.Driver;

public class CabTransformer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .ratePerKm(cabRequest.getRatePerKm())
                .model(cabRequest.getModel())
                .isAvailable(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .driverResponse(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }

    public static CabResponseForDriver cabToCabResponseForDriver(Cab cab){
        return CabResponseForDriver.builder()
                .cabNumber(cab.getCabNumber())
                .ratePerKm(cab.getRatePerKm())
                .model(cab.getModel())
                .isAvailable(cab.isAvailable())
                .build();
    }
}
