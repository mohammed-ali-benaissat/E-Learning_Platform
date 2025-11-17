package com.example.lms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student in the system.
 */
public class Student extends User {
    private final List<String> enrolledCourses;

    private Student(Builder builder) {
        super(builder);
        this.enrolledCourses = builder.enrolledCourses;
    }

    public void enroll(String course) {
        enrolledCourses.add(course);
        System.out.println(getName() + " enrolled in " + course);
    }

    public List<String> getEnrolledCourses() {
        return List.copyOf(enrolledCourses);
    }

    public static class Builder extends User.Builder<Builder> {
        private List<String> enrolledCourses = new ArrayList<>();

        public Builder enrolledCourses(List<String> courses) {
            this.enrolledCourses = new ArrayList<>(courses);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Student build() {
            return new Student(this);
        }
    }
}
