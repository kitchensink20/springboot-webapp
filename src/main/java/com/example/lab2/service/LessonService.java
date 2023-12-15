package com.example.lab2.service;

import com.example.lab2.repository.LessonRepositoryImpl;
import org.springframework.stereotype.Service;
import com.example.lab2.model.Lesson;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepositoryImpl lessonRepository;

    public LessonService(LessonRepositoryImpl lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


}
