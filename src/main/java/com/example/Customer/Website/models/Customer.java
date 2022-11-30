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

    public Customer(String fullName, String emailAddress, Integer age, String address) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String fullName;
    private String emailAddress;
    private Integer age;
    private String address;

    @OneToOne(mappedBy = "customer")
    private RentalCar car;

    @OneToOne(mappedBy = "customer")
    private Insurance insurance;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", car=" + car +
                ", insurance=" + insurance +
                '}';
    }
}
