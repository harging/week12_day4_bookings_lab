package com.codeclan.example.BookingsLab.BookingsLab.controllers;

import com.codeclan.example.BookingsLab.BookingsLab.models.Course;
import com.codeclan.example.BookingsLab.BookingsLab.repositories.CourseRepository;
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
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity <Optional<Course>> getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/coursesbycustomer")
    public ResponseEntity<List<Course>> getCoursesByCustomer(@RequestParam(name = "name") String name){
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/getbyrating")
    public ResponseEntity<List<Course>> getCoursesByRating(@RequestParam(name = "star_rating") int star_rating){
        return new ResponseEntity<>(courseRepository.findByStarRating(star_rating), HttpStatus.OK);
    }
}
