package com.example.lab2.service;

import com.example.lab2.model.Professor;
import com.example.lab2.repository.ProfessorRepositoryStub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepositoryStub professorRepository;

    public ProfessorService(ProfessorRepositoryStub professorRepository) {
        this.professorRepository = professorRepository;
    }

}
