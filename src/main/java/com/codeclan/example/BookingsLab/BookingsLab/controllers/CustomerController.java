package com.codeclan.example.BookingsLab.BookingsLab.controllers;

import com.codeclan.example.BookingsLab.BookingsLab.models.Customer;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity <Optional<Customer>> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbycustomer")
    public ResponseEntity<List<Customer>> getByCustomer(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbytownandcourse")
    public ResponseEntity<List<Customer>> getByTownAndCourse(@RequestParam(name = "town") String town,
                                                            @RequestParam(name = "course") String course){
        return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbyageandtownandcourse")
    public ResponseEntity<List<Customer>> getByAgeTownAndCourse(@RequestParam(name = "town") String town,
                                                             @RequestParam(name = "course") String course,
                                                                @RequestParam(name = "age") int age){
        return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(town, course, age), HttpStatus.OK);
    }


}
