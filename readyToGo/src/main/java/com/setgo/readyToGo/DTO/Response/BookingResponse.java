package com.setgo.readyToGo.DTO.Response;

import java.util.Date;
import com.setgo.readyToGo.Enum.TripStatus;
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
public class BookingResponse {
    private String source;
    private String destination;
    private double fare;
    private double distanceInKm;
    private TripStatus status;
    Date bookedAt;
    Date lastUpdatedAt;
    private CustomerResponse customerResponse;
    private DriverResponse driverResponse;
}
