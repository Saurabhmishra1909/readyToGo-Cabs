package com.setgo.readyToGo.Model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.setgo.readyToGo.Enum.TripStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    
    private String source;
    private String destination;
    private double fare;
    private double distanceInKm;

    @Enumerated(value=EnumType.STRING)
    private TripStatus status;

    @CreationTimestamp
    Date bookedAt;
    @UpdateTimestamp
    Date lastUpdatedAt;
}
