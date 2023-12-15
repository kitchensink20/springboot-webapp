package com.example.lab2.repository;

import com.example.lab2.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorRepositoryStub implements GenericRepository<Professor> {

    @Override
    public Professor findById(int id) {
        return null;
    }

    @Override
    public List<Professor> findAll() {
        return null;
    }

    @Override
    public Professor create(Professor newEntity) {
        return null;
    }

    @Override
    public Professor update(Professor modifiedEntity) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}