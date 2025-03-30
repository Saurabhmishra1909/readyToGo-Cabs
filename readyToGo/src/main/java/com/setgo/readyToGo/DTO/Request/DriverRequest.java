package com.setgo.readyToGo.DTO.Request;

import com.setgo.readyToGo.Enum.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverRequest{
    private String name;
    private int age;
    private String email;
    private String phone;
    private Gender gender;
}