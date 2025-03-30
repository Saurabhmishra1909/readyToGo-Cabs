package com.setgo.readyToGo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.setgo.readyToGo.Model.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

    @Query("SELECT c FROM Cab c WHERE c.isAvailable = true")
    List<Cab> findAllAvailableCabs();
}
