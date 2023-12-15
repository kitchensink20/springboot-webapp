package com.example.lab2.service;

import com.example.lab2.model.Mark;
import com.example.lab2.repository.MarkRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepositoryImpl markRepository;

    public MarkService(MarkRepositoryImpl markRepository) {
        this.markRepository = markRepository;
    }


}
