package com.setgo.readyToGo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabID;
    @Column(unique = true, nullable = false)
    private String cabNumber;
    private String model;
    private double ratePerKm;
    private boolean isAvailable;
    
}
