package com.setgo.readyToGo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setgo.readyToGo.DTO.Request.BookingRequest;
import com.setgo.readyToGo.DTO.Response.BookingResponse;
import com.setgo.readyToGo.Service.BookingService;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/book/{customerId}")
    public ResponseEntity<BookingResponse>bookCab(@RequestBody BookingRequest bookingRequest,
                                                  @PathVariable int customerId){
            return new ResponseEntity<>(bookingService.bookCab(bookingRequest,customerId),HttpStatus.OK);                                        
    }

}
