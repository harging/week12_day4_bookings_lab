package com.codeclan.example.BookingsLab.BookingsLab.repositories;

import com.codeclan.example.BookingsLab.BookingsLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseNameIgnoreCase(String name);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String course);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(String town, String course, int age);
}
