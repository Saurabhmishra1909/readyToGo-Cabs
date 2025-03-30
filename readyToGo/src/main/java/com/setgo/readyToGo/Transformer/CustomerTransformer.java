package com.setgo.readyToGo.Transformer;
import com.setgo.readyToGo.Model.Customer;
import com.setgo.readyToGo.DTO.Request.CustomerRequest;
import com.setgo.readyToGo.DTO.Response.CustomerResponse;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .gender(customerRequest.getGender())
                .build();
        
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

}
