package com.setgo.readyToGo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.setgo.readyToGo.Enum.Gender;
import com.setgo.readyToGo.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer>findByGender(Gender gender);
    List<Customer>findByGenderAndAge(Gender gender,int age);
    @Query("Select c From Customer c Where c.age>:age")
    List<Customer>getByAgeGreaterThan(@Param("age")int age);
    @Query("Select c From Customer c Where c.age<:age And c.gender=:gender")
    List<Customer>getByAgeLessThanAndGender(
        @Param("age")int age,
        @Param("gender") Gender gender
    );
}
