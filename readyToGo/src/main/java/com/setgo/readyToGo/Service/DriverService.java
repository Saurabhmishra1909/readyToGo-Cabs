package com.setgo.readyToGo.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setgo.readyToGo.DTO.Request.DriverRequest;
import com.setgo.readyToGo.DTO.Response.DriverResponse;
import com.setgo.readyToGo.Enum.Gender;
import com.setgo.readyToGo.Model.Driver;
import com.setgo.readyToGo.Repository.DriverRepository;
import com.setgo.readyToGo.Transformer.DriverTransformer;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest){
        //Dto to Entity
        Driver driver=DriverTransformer.diverRequestToDriver(driverRequest);
        
        Driver saveDriver=driverRepository.save(driver);
        //Entity to Dto
        return DriverTransformer.driverToDriverResponse(saveDriver);
    }

    public DriverResponse getDriverById(int driverId){
        Driver driver=driverRepository.findById(driverId).get();
        //Entity to Dto
        return DriverTransformer.driverToDriverResponse(driver);
    }

    public DriverResponse getDriverByNumber(String phoneNo){
        Driver driver=driverRepository.findByPhone(phoneNo);
        return DriverTransformer.driverToDriverResponse(driver);
    }

    public List<DriverResponse> getDriverByGender(Gender gender){
        List<Driver>drivers=driverRepository.findByGender(gender);
        List<DriverResponse> driverResponseList=new ArrayList<>();
        for(Driver driver:drivers){
            driverResponseList.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponseList;
    }
}
