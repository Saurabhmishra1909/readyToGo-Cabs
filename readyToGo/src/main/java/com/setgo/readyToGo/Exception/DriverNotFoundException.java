package com.setgo.readyToGo.Exception;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String driverId){
        super(driverId+" not found");
    }
}
