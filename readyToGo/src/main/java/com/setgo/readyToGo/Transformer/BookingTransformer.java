package com.setgo.readyToGo.Transformer;

import com.setgo.readyToGo.DTO.Request.BookingRequest;
import com.setgo.readyToGo.DTO.Response.BookingResponse;
import com.setgo.readyToGo.Enum.TripStatus;
import com.setgo.readyToGo.Model.Booking;
import com.setgo.readyToGo.Model.Customer;
import com.setgo.readyToGo.Model.Driver;

public class BookingTransformer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest,double ratePerKm) {
        return Booking.builder()
                      .source(bookingRequest.getSource())
                      .destination(bookingRequest.getDestination())
                      .distanceInKm(bookingRequest.getDistanceInKm())
                      .status(TripStatus.INPROGRESS)
                      .fare(bookingRequest.getDistanceInKm()*ratePerKm)
                       .build();

    }
    public static BookingResponse bookingToBookingRequest(Booking booking,Customer customer,Driver driver) {
        return BookingResponse.builder()
                      .source(booking.getSource())
                      .destination(booking.getDestination())
                      .distanceInKm(booking.getDistanceInKm())
                      .fare(booking.getFare())
                      .status(booking.getStatus())
                      .bookedAt(booking.getBookedAt())
                      .lastUpdatedAt(booking.getLastUpdatedAt())
                      .customerResponse(CustomerTransformer.customerToCustomerResponse(customer))
                      .driverResponse(DriverTransformer.driverToDriverResponse(driver))
                    .build();

    }
}
