package com.example.Customer.Website.controllers;

import com.example.Customer.Website.models.Customer;
import com.example.Customer.Website.models.Insurance;
import com.example.Customer.Website.models.RentalCar;
import com.example.Customer.Website.services.CarService;
import com.example.Customer.Website.services.CustomerService;
import com.example.Customer.Website.services.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/insurance")
    public String viewHomePage (Model model) {
        final List<Insurance> insuranceList = insuranceService.getInsurance();
        model.addAttribute("insuranceList", insuranceList);
        return "insurance";
    }

    @GetMapping("/new-insurance")
    public String showNewInsurance(Model model) {
        Insurance insurance = new Insurance();
        model.addAttribute("insurance", insurance);
        return "new-insurance";
    }

    @PostMapping("/insurance")
    public String saveInsurance(@ModelAttribute("insurance") Insurance insurance, Model model) {
        try {
            insuranceService.saveInsurance(insurance);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Could not save insurance, " + e.getMessage());
            return"error-page";
        }
        return"redirect:/insurance";
    }

    @RequestMapping("remove/insurance/{id}")
    public String removeInsurance(@PathVariable(name = "id") Long insuranceId) {
        Insurance insurance = insuranceService.getInsurance(insuranceId);
        insurance.setCustomer(null);
        insuranceService.saveInsurance(insurance);
        return"redirect/:";
    }

    @GetMapping("/insurance/assign/{id}")
    public String assignInsurance(@PathVariable(name = "id") Long id, Model model){
        Customer customer = customerService.getCustomer(id);
        List<Insurance> insuranceList = insuranceService.getAvailableInsurance();
        model.addAttribute("customer", customer);
        model.addAttribute("insuranceList", insuranceList);
        return "assign-insurance";
    }

    @PostMapping("insurance/assign")
    public String saveInsuranceAssignment(@RequestParam("customerId") Long customerId, @RequestParam("insuranceId") Long insuranceId) {
       Insurance insurance = insuranceService.getInsurance(insuranceId);
        insurance.setCustomer(customerService.getCustomer(customerId));
        insuranceService.saveInsurance(insurance);
        return "redirect:/";
    }


}
