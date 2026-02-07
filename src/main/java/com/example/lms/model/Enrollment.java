/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.lms.model;

/**
 *
 * @author Projects Lab
 */
import java.time.LocalDate;

public class Enrollment {

    private final int id;
    private final Student student;
    private final Course course;
    private final LocalDate enrollmentDate;
    private boolean active;

    public Enrollment(int id, Student student, Course course, LocalDate now) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        this.active = false;
    }
}
