package com.setgo.readyToGo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.setgo.readyToGo.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}
