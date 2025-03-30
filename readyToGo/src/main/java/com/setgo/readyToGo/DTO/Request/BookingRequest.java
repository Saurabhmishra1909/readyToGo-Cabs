package com.setgo.readyToGo.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String source;
    private String destination;
    private double distanceInKm;
}
