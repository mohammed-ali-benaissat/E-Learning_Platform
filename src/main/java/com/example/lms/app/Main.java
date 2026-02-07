package com.example.lms.app;

import com.example.lms.model.Admin;
import com.example.lms.model.ContentType;
import com.example.lms.model.Course;
import com.example.lms.model.CourseContent;
import com.example.lms.model.Instructor;
import com.example.lms.model.Student;
import com.example.lms.model.User;
import java.time.LocalDate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User student = new Student.Builder()
                .id(1)
                .name("Alice")
                .email("alice@example.com")
                .password("pass123")
                .age(20)
                .phoneNumber("123456789")
                .enrolledCourses(List.of("Java SE 17"))
                .build();

        Instructor instructor = new Instructor.Builder()
                .id(2)
                .name("Bob")
                .email("bob@example.com")
                .password("securePass")
                .coursesCreated(List.of("Advanced Java"))
                .build();

        Admin admin = new Admin.Builder()
                .id(3)
                .name("Carol")
                .email("carol@example.com")
                .password("adminPass")
                .managedUsers(List.of("Alice", "Bob"))
                .build();
        
        Course course = new Course.Builder()
        .id(1)
        .title("Java SE 17")
        .description("Complete Java fundamentals")
        .category("Backend")
        .level("Beginner")
        .duration(40)
        .price(99.0)
        .published(true)
        .instructor(instructor)
        .publishDate(LocalDate.now())
        .build();

        
        CourseContent content = new CourseContent.Builder()
        .id(1)
        .title("Introduction to Java")
        .order(1)
        .duration(15)
        .contentType(ContentType.VIDEO)
        .contentUrl("https://video-url")
        .course(course)
        .build();

        // Actions
        ((Student) student).enroll("Spring Boot Basics");
        instructor.createCourse("Microservices");
        admin.manageUser("Alice");

        // Login/Logout
        student.login();
        instructor.login();
        admin.login();
    }
    
    
    

}
