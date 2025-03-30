package com.setgo.readyToGo.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CabResponse {
    // private String cabNumber;
    // private String model;
    // private double ratePerKm;
    // private boolean isAvailable;
    private DriverResponse driverResponse;
}
