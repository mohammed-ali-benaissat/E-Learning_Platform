package com.example.lms.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an instructor in the system.
 */
public class Instructor extends User {
    private final List<String> coursesCreated;

    private Instructor(Builder builder) {
        super(builder);
        this.coursesCreated = builder.coursesCreated;
    }

    public void createCourse(String course) {
        coursesCreated.add(course);
        System.out.println(getName() + " created course " + course);
    }

    public List<String> getCoursesCreated() {
        return List.copyOf(coursesCreated);
    }

    public static class Builder extends User.Builder<Builder> {
        private List<String> coursesCreated = new ArrayList<>();

        public Builder coursesCreated(List<String> courses) {
            this.coursesCreated = new ArrayList<>(courses);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Instructor build() {
            return new Instructor(this);
        }
    }
}
