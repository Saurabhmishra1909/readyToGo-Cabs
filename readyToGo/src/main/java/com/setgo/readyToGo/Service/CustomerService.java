package com.setgo.readyToGo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setgo.readyToGo.Model.Customer;
import com.setgo.readyToGo.DTO.Request.CustomerRequest;
import com.setgo.readyToGo.DTO.Response.CustomerResponse;
import com.setgo.readyToGo.Exception.CustomerNotFoundException;
import com.setgo.readyToGo.Repository.CustomerRepository;
import com.setgo.readyToGo.Transformer.CustomerTransformer;

@Service
public class CustomerService {
    @Autowired

    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer=CustomerTransformer.customerRequestToCustomer(customerRequest);
        //Dto to Entity
        Customer saveCustomer= customerRepository.save(customer);
        //Entity to Dto
        return CustomerTransformer.customerToCustomerResponse(saveCustomer);
    }

    public CustomerResponse getCustomerById(int customerId) {
        Optional<Customer> customer=customerRepository.findById(customerId);
        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found with id: "+customerId);
        }
        //Entity to Dto
        Customer savedResponse=customer.get();
        return CustomerTransformer.customerToCustomerResponse(savedResponse);
    }
}
