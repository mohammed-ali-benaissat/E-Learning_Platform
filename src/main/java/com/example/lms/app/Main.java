package com.example.lms.app;

import com.example.lms.model.*;
import com.example.lms.repo.*;
import com.example.lms.service.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ---------------- REPOSITORIES ----------------
        EnrollmentRepository enrollmentRepo = new EnrollmentRepository();
        ProgressRepository progressRepo = new ProgressRepository();
        CertificateRepository certificateRepo = new CertificateRepository();
        SubscriptionRepository subscriptionRepo = new SubscriptionRepository();

        // ---------------- SERVICES ----------------
        PaymentService paymentService = new PaymentService();
        SubscriptionService subscriptionService = new SubscriptionService();
        EnrollmentService enrollmentService = new EnrollmentService();
        ProgressService progressService = new ProgressService();
        CertificationService certificateService = new CertificationService();

        // ---------------- USERS ----------------
        Student student = new Student.Builder()
                .id(1)
                .name("Amine")
                .age(22)
                .email("amine@email.com")
                .phoneNumber("0600000000")
                .password("secret")
                .build();

        Instructor instructor = new Instructor.Builder()
                .id(2)
                .name("Instructor One")
                .age(40)
                .email("inst@email.com")
                .phoneNumber("0700000000")
                .password("secret")
                .build();

        // ---------------- COURSE ----------------
        Course course = new Course.Builder()
                .id(100)
                .title("Java Fundamentals")
                .duration(30)
                .instructor(instructor)
                .build();

        CourseContent c1 = new CourseContent.Builder()
                .id(1)
                .title("Intro")
                .description("Course introduction")
                .order(1)
                .duration(10)
                .contentType(ContentType.VIDEO)
                .contentUrl("intro.mp4")
                .course(course)
                .build();

        CourseContent c2 = new CourseContent.Builder()
                .id(2)
                .title("OOP")
                .description("Object Oriented Programming")
                .order(2)
                .duration(15)
                .contentType(ContentType.VIDEO)
                .contentUrl("oop.mp4")
                .course(course)
                .build();

        CourseContent c3 = new CourseContent.Builder()
                .id(3)
                .title("Streams")
                .description("Java Streams API")
                .order(3)
                .duration(20)
                .contentType(ContentType.VIDEO)
                .contentUrl("streams.mp4")
                .course(course)
                .build();


        List<CourseContent> contents = List.of(c1, c2, c3);

        // ---------------- PAYMENT ----------------
        Payment payment = paymentService.processPayment(1, student, 100.0);

        if (!payment.isPaid()) {
            throw new IllegalStateException("Payment failed");
        }

        // ---------------- SUBSCRIPTION ----------------
        Subscription subscription = subscriptionService.createSubscription(
                1,
                student,
                SubscriptionType.MONTHLY,
                LocalDate.now()
        );
        subscriptionRepo.save(subscription);

        // ---------------- ENROLLMENT ----------------
        Enrollment enrollment = enrollmentService.enroll(
                student,
                course,
                subscription,
                enrollmentRepo.findAll()
        );
        enrollmentRepo.save(enrollment);

        // ---------------- PROGRESS ----------------
        for (CourseContent content : contents) {
            progressService.updateProgress(
                    enrollment,
                    content,
                    progressRepo.findAll()
            );
        }

        boolean completed = progressService.isCourseCompleted(
                enrollment,
                contents,
                progressRepo.findAll()
        );

        // ---------------- CERTIFICATE ----------------
        if (completed) {
            Certificate certificate = certificateService.issueCertificate(
                    student,
                    course,
                    certificateRepo.findAll()
            );
            certificateRepo.save(certificate);

            System.out.println("🎉 COURSE COMPLETED!");
            System.out.println("Certificate Code: " + certificate.getCertificateCode());
        }
    }
}
