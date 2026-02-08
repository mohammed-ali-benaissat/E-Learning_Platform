package com.example.lms.service;

import com.example.lms.model.Certificate;
import com.example.lms.model.Course;
import com.example.lms.model.Student;

import java.time.LocalDate;
import java.util.List;

public class CertificationService {

    public Certificate issueCertificate(
            Student student,
            Course course,
            List<Certificate> existingCertificates) {

        // prevent duplicates
        for (Certificate certificate : existingCertificates) {
            if (certificate.getStudent().equals(student)
                    && certificate.getCourse().equals(course)) {
                throw new IllegalStateException(
                        "Certificate already issued for this course");
            }
        }

        Certificate certificate = new Certificate.Builder()
                .id(generateId())
                .student(student)
                .course(course)
                .issueDate(LocalDate.now())
                .certificateCode(generateCode())
                .certificateUrl(generateUrl())
                .build();

        existingCertificates.add(certificate);
        return certificate;
    }

    // ------------ helpers ------------

    private int generateId() {
        return (int) (Math.random() * 100_000);
    }

    private String generateCode() {
        return "CERT-" + System.currentTimeMillis();
    }

    private String generateUrl() {
        return "https://lms.example.com/certificates/" + generateCode();
    }
}
