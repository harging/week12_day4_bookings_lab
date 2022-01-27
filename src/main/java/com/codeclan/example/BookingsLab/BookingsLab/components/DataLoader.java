package com.codeclan.example.BookingsLab.BookingsLab.components;

import com.codeclan.example.BookingsLab.BookingsLab.models.Booking;
import com.codeclan.example.BookingsLab.BookingsLab.models.Course;
import com.codeclan.example.BookingsLab.BookingsLab.models.Customer;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.BookingRepository;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.CourseRepository;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Customer cust1 = new Customer("Jonny", "Edinburgh", 21);
        customerRepository.save(cust1);

        Course course1 = new Course("Japanese 101", "Edinburgh", 5);
        courseRepository.save(course1);

        Booking booking1 = new Booking("21-01-22", course1, cust1);
        bookingRepository.save(booking1);
    }
}
