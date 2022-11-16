package com.example.Customer.Website.repositories;

import com.example.Customer.Website.models.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository <RentalCar, Long> {

    RentalCar findByCustomerId (Long id);

}
