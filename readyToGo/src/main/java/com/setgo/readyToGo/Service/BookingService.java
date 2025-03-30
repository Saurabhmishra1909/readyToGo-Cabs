package com.setgo.readyToGo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.setgo.readyToGo.DTO.Request.BookingRequest;
import com.setgo.readyToGo.DTO.Response.BookingResponse;
import com.setgo.readyToGo.Exception.CustomerNotFoundException;
import com.setgo.readyToGo.Exception.DriverNotFoundException;
import com.setgo.readyToGo.Model.Booking;
import com.setgo.readyToGo.Model.Cab;
import com.setgo.readyToGo.Model.Customer;
import com.setgo.readyToGo.Model.Driver;
import com.setgo.readyToGo.Repository.BookingRepository;
import com.setgo.readyToGo.Repository.CustomerRepository;
import com.setgo.readyToGo.Repository.DriverRepository;
import com.setgo.readyToGo.Transformer.BookingTransformer;

@Service
public class BookingService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest,int customerId){
        Optional<Customer>optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found with id: " + customerId);
        }
        Customer customer=optionalCustomer.get();
        if(driverRepository.findRandomDriverWithCab().isEmpty()){
            throw new DriverNotFoundException("No cabs available at the moment");
        }
        Driver driver=driverRepository.findRandomDriverWithCab().get();
        Cab cab=driver.getCab();

        Booking booking=BookingTransformer.bookingRequestToBooking(bookingRequest,cab.getRatePerKm());
        Booking savedBooking=bookingRepository.save(booking);

        driver.getBookings().add(booking);
        cab.setAvailable(false);
        customer.getBookings().add(booking);

        Driver savedDriver=driverRepository.save(driver);
        Customer savedCustomer=customerRepository.save(customer);

        return BookingTransformer.bookingToBookingRequest(savedBooking,savedCustomer,savedDriver);
    }
}
