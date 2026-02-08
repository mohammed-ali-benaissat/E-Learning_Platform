package com.example.lms.repo;

import com.example.lms.model.Progress;

import java.util.ArrayList;
import java.util.List;

public class ProgressRepository {

    private final List<Progress> progresses = new ArrayList<>();

    public void save(Progress progress) {
        progresses.add(progress);
    }

    public List<Progress> findAll() {
        return progresses;
    }
}
