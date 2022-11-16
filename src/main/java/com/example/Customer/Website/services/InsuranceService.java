package com.example.Customer.Website.services;

import com.example.Customer.Website.models.Insurance;
import com.example.Customer.Website.models.RentalCar;
import com.example.Customer.Website.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    public List<Insurance> getInsurance() {return insuranceRepository.findAll();}

    public List<Insurance> getAvailableInsurance() {
        return getInsurance().stream().filter(c -> c.getCustomer() == null)
                .collect(Collectors.toList());
    }

    public Insurance getInsurance (Long id) {
        return insuranceRepository.findById(id)
                .orElse(null);
    }

    @Transactional
    public Insurance saveInsurance(Insurance insurance) throws IllegalArgumentException {
        return insuranceRepository.save(insurance);
    }

    public void removeAssignment (Long customerId) {
        Insurance insurance = insuranceRepository.findByCustomerId(customerId);
        if (insurance != null) {
            insurance.setCustomer(null);
            saveInsurance(insurance);
        }
    }

}
