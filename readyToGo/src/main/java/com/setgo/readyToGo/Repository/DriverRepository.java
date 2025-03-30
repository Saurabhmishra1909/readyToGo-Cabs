package com.setgo.readyToGo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.setgo.readyToGo.Enum.Gender;
import com.setgo.readyToGo.Model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver>findByGender(Gender gender);
    Driver findByPhone(String phoneNo);
    
    @Query(value = """
        SELECT d.* FROM driver d
        JOIN cab c ON d.cab_id = c.cabid
        WHERE d.cab_id IS NOT NULL
        AND c.is_available = true
        ORDER BY RAND()
        LIMIT 1
        """, nativeQuery = true)
    Optional<Driver> findRandomDriverWithCab();
}
