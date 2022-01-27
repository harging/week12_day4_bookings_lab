package com.codeclan.example.BookingsLab.BookingsLab.repositories;

import com.codeclan.example.BookingsLab.BookingsLab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByBookingsCustomerNameIgnoreCase(String name);

    List<Course> findByStarRating(int rating);
}
