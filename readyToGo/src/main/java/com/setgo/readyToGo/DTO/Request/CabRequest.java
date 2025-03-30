package com.setgo.readyToGo.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CabRequest {
    private String cabNumber;
    private String model;
    private double ratePerKm;
}
