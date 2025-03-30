package com.setgo.readyToGo.Service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setgo.readyToGo.Model.Customer;
import com.setgo.readyToGo.DTO.Request.CustomerRequest;
import com.setgo.readyToGo.DTO.Response.CustomerResponse;
import com.setgo.readyToGo.Enum.Gender;
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

    public List<CustomerResponse> getCustomerByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);
        List<CustomerResponse> customerResponse = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponse.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponse;
    }

    public List<CustomerResponse> getByGenderAndAge(Gender gender,int age){
        List<Customer>customers= customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse>customerResponse=new ArrayList<>();
        for(Customer customer:customers){
            customerResponse.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponse;
    }

    public List<CustomerResponse> getByAgeGreaterThan(int age){
        List<Customer>customers= customerRepository.getByAgeGreaterThan(age);
        List<CustomerResponse>customerResponse=new ArrayList<>();
        for(Customer customer:customers){
            customerResponse.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponse;
    }

    public List<CustomerResponse>  getByAgeLessThanAndGender(int age,Gender gender){
        List<Customer>customers= customerRepository. getByAgeLessThanAndGender(age,gender);
        List<CustomerResponse>customerResponse=new ArrayList<>();
        for(Customer customer:customers){
            customerResponse.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponse;
    }
}
