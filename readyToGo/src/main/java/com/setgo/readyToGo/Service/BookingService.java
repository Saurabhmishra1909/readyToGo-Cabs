package com.setgo.readyToGo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

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
    @Autowired
    JavaMailSender javaMailSender;

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
        sendEmail(BookingTransformer.bookingToBookingRequest(savedBooking,savedCustomer,savedDriver),savedCustomer);
        return BookingTransformer.bookingToBookingRequest(savedBooking,savedCustomer,savedDriver);
    }

    private void sendEmail(BookingResponse bookingResponse, Customer customer) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        String text = String.format(
            "Dear %s,\n\n" +
            "Your cab has been booked successfully!\n\n" +
            "Booking Details:\n" +
            "----------------\n" +
            "From: %s\n" +
            "To: %s\n" +
            "Distance: %.2f km\n" +
            "Fare: ₹%.2f\n" +
            "Status: %s\n" +
            "Booked At: %s\n" +
            "Last Updated: %s\n\n" +
            "Driver Details:\n" +
            "--------------\n" +
            "Name: %s\n" +
            "Contact: %s\n" +
            "Cab: %s (%s)\n\n" +
            "Thank you for choosing our service!\n" +
            "ReadyToGo Team",
            customer.getName(),
            bookingResponse.getSource(),
            bookingResponse.getDestination(),
            bookingResponse.getDistanceInKm(),
            bookingResponse.getFare(),
            bookingResponse.getStatus(),
            bookingResponse.getBookedAt(),
            bookingResponse.getLastUpdatedAt(),
            bookingResponse.getDriverResponse().getName(),
            bookingResponse.getDriverResponse().getPhone(),
            bookingResponse.getDriverResponse().getAssociatedCabDetail().getModel(),
            bookingResponse.getDriverResponse().getAssociatedCabDetail().getCabNumber()
        );

        message.setFrom("nepalmoments4@gmail.com");
        message.setTo(customer.getEmail());
        message.setSubject("Cab Booked Successfully");
        message.setText(text);
        
        javaMailSender.send(message);
    }
}
