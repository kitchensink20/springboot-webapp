package com.example.lab2.service;

import com.example.lab2.repository.LessonRepositoryStub;
import org.springframework.stereotype.Service;
import com.example.lab2.model.Lesson;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepositoryStub lessonRepository;

    public LessonService(LessonRepositoryStub lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson findById(int id) {
        return  lessonRepository.findById(id);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public List<Lesson> findLessonsByProfId(int profId) {
        return lessonRepository.findLessonsByProfId(profId);
    }

    public void createLesson(Lesson lesson) {
        lessonRepository.createLesson(lesson);
    }

    public void deleteById(int id) {
        lessonRepository.deleteById(id);
    }
}
