package com.example.lms.repo;

import com.example.lms.model.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }
}
