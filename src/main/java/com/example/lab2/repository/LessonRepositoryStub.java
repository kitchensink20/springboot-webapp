package com.example.lab2.repository;

import com.example.lab2.model.Lesson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LessonRepositoryStub {
    private static List<Lesson> lessons = new ArrayList<Lesson>();

    static {
        Lesson lesson1 = new Lesson(1, "Data structures", 2, "Monday", 2);
        Lesson lesson2 = new Lesson(2, "Algorithms", 3, "Friday", 1);
        Lesson lesson3 = new Lesson(3, "Java", 1, "Friday", 4);
        Lesson lesson4 = new Lesson(4, "Operational systems", 5, "Thursday", 2);
        Lesson lesson5 = new Lesson(5, "Philosophy", 4, "Monday", 1);
        lessons.add(lesson1);
        lessons.add(lesson2);
        lessons.add(lesson3);
        lessons.add(lesson4);
        lessons.add(lesson5);
    }

    public Lesson findById(int id) {
        return  lessons.stream()
                .filter(l -> l.getLessonId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Lesson> findLessonsByProfId(int profId) {
        return lessons.stream()
                .filter(l -> l.getProfessorId() == profId)
                .collect(Collectors.toList());
    }

    public List<Lesson> findAll() {
        return lessons;
    }

    public void createLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void deleteById(int id) {
        lessons.removeIf(l -> l.getLessonId() == id);
    }
}
