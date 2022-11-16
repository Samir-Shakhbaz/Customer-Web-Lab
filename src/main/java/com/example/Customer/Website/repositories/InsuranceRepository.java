package com.example.Customer.Website.repositories;

import com.example.Customer.Website.models.Insurance;
import com.example.Customer.Website.models.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    Insurance findByCustomerId (Long id);

}
