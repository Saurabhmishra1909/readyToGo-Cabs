package com.setgo.readyToGo.Model;

import java.util.*;

import com.setgo.readyToGo.Enum.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    @Builder.Default
    private List<Booking>bookings=new ArrayList<>();
}
