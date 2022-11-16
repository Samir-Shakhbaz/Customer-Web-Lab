package com.example.Customer.Website.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Builder
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String fullName;
    private String emailAddress;
    private Integer age;
    private String address;

    @OneToOne(mappedBy = "customer")
    private RentalCar car;

    @OneToOne(mappedBy = "customer")
    private Insurance insurance;


}
