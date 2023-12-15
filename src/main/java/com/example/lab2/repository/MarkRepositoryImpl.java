package com.example.lab2.repository;

import com.example.lab2.model.Mark;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MarkRepositoryImpl implements GenericRepository<Mark> {
    @Override
    public Mark findById(int id) {
        return null;
    }

    @Override
    public List<Mark> findAll() {
        return null;
    }

    @Override
    public Mark create(Mark newEntity) {
        return null;
    }

    @Override
    public Mark update(Mark modifiedEntity) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
