package com.setgo.readyToGo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setgo.readyToGo.DTO.Response.CustomerResponse;
import com.setgo.readyToGo.DTO.Request.CustomerRequest;
import com.setgo.readyToGo.Service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {
        @Autowired
        CustomerService customerService;
        @PostMapping("/add")
        public ResponseEntity<CustomerResponse>addCustomer(@RequestBody CustomerRequest customerRequest){
            return new ResponseEntity<>(customerService.addCustomer(customerRequest), HttpStatus.CREATED);
        } 

        @GetMapping("/get/customerId/{customerId}")
        public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable int customerId) {
            return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
        }
}
