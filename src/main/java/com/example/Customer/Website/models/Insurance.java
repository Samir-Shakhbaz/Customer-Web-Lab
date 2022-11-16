package com.example.Customer.Website.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insurance")
@Builder
@Getter
@Setter
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String insurerName;
    private Long serialNumber;

    @OneToOne
    @JoinColumn(name = "customer_insurance_id")
    private Customer customer;



}
