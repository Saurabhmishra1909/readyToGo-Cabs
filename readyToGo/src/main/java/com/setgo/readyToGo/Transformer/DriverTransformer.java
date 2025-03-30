package com.setgo.readyToGo.Transformer;
import com.setgo.readyToGo.DTO.Request.DriverRequest;
import com.setgo.readyToGo.DTO.Response.DriverResponse;
import com.setgo.readyToGo.Model.Driver;

public class DriverTransformer {

    public static Driver diverRequestToDriver(DriverRequest driverRequest) {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .email(driverRequest.getEmail())
                .phone(driverRequest.getPhone())
                .gender(driverRequest.getGender())
                .build();
        
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .age(driver.getAge())
                .email(driver.getEmail())
                .phone(driver.getPhone())
                .associatedCabDetail(driver.getCab() != null ? 
                CabTransformer.cabToCabResponseForDriver(driver.getCab()) : 
                null)
                .build();
    }
}
