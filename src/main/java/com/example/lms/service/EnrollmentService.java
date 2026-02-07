/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.service;

/**
 *
 * @author Projects Lab
 */
import com.example.lms.model.Course;
import com.example.lms.model.Enrollment;
import com.example.lms.model.Student;
import com.example.lms.model.Subscription;
import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {

    public Enrollment enroll(
            Student student,
            Course course,
            Subscription subscription,
            List<Enrollment> existingEnrollments) {

        if (subscription == null || !subscription.isActive()) {
            throw new IllegalStateException("Student does not have an active subscription");
        }

        for (Enrollment enrollment : existingEnrollments) {
            if (enrollment.getStudent().equals(student)
                    && enrollment.getCourse().equals(course)
                    && enrollment.isActive()) {
                throw new IllegalStateException("Student already enrolled in this course");
            }
        }

        return new Enrollment(
                generateId(),
                student,
                course,
                LocalDate.now()
        );
    }

    private int generateId() {
        return (int) (Math.random() * 100_000);
    }
}
