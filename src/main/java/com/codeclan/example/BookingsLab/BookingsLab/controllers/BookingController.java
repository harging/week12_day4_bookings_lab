package com.codeclan.example.BookingsLab.BookingsLab.controllers;

import com.codeclan.example.BookingsLab.BookingsLab.models.Booking;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.BookingRepository;
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
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity <Optional<Booking>> getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/getbydate")
    public ResponseEntity<List<Booking>> getByDate(@RequestParam(name = "date") String date){
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }
}
