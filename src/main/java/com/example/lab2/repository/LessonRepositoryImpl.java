package com.example.lab2.repository;

import com.example.lab2.model.Lesson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepositoryImpl implements GenericRepository<Lesson> {

    @Override
    public Lesson findById(int id) {
        return null;
    }

    @Override
    public List<Lesson> findAll() {
        return null;
    }

    @Override
    public Lesson create(Lesson newEntity) {
        return null;
    }

    @Override
    public Lesson update(Lesson modifiedEntity) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
