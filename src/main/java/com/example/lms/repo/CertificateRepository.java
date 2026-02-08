package com.example.lms.repo;

import com.example.lms.model.Certificate;

import java.util.ArrayList;
import java.util.List;

public class CertificateRepository {

    private final List<Certificate> certificates = new ArrayList<>();

    public void save(Certificate certificate) {
        certificates.add(certificate);
    }

    public List<Certificate> findAll() {
        return certificates;
    }
}
