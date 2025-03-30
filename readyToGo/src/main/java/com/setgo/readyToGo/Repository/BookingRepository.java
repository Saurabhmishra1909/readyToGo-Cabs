package com.setgo.readyToGo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.setgo.readyToGo.Model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
