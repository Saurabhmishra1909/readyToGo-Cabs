package com.setgo.readyToGo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.setgo.readyToGo.DTO.Response.CustomerResponse;
import com.setgo.readyToGo.Enum.Gender;
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

        @GetMapping("/get/{gender}")
        public ResponseEntity<List<CustomerResponse>> getCustomerByGender(@PathVariable Gender gender){
            return new ResponseEntity<>(customerService.getCustomerByGender(gender),HttpStatus.OK);
        }

        @GetMapping("/get")
        public ResponseEntity<List<CustomerResponse>> getByGenderAndAge(
            @RequestParam("gender") Gender gender ,
            @RequestParam("age") int age){
            return new ResponseEntity<>(customerService.getByGenderAndAge(gender,age),HttpStatus.OK);
        }

        @GetMapping("/get/age-greater-than/{age}")
        public ResponseEntity<List<CustomerResponse>> getByAgeGreaterThan(@PathVariable int age){
            return new ResponseEntity<>(customerService.getByAgeGreaterThan(age),HttpStatus.OK);
        }

        @GetMapping("/get/GenderAndAgeGreaterThan/{age}/{gender}")
        public ResponseEntity<List<CustomerResponse>> getByAgeLessThanAndGender(
            @PathVariable int age,
            @PathVariable Gender gender){
            return new ResponseEntity<>(customerService.getByAgeLessThanAndGender(age,gender),HttpStatus.OK);
        }

}
