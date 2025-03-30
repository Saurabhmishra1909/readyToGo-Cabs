package com.setgo.readyToGo.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
    private String name;
    private int age;
    private String email;
    private String phone;
    private CabResponseForDriver associatedCabDetail;
}
