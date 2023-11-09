package com.example.lab2.repository;

import com.example.lab2.model.Mark;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MarkRepositoryStub {
    private static List<Mark> marks = new ArrayList<Mark>();

    static {
        Mark mark1 = new Mark(1, 2, 1, LocalDate.of(2023, 10, 10), 9);
        Mark mark2 = new Mark(2, 1, 3, LocalDate.of(2023, 10, 11), 10);
        Mark mark3 = new Mark(3, 3, 1, LocalDate.of(2023, 10, 10), 8);
        Mark mark4 = new Mark(4, 1, 2, LocalDate.of(2023, 10, 11), 10);
        Mark mark5 = new Mark(5, 5, 1, LocalDate.of(2023, 10, 10), 9);
        marks.add(mark1);
        marks.add(mark2);
        marks.add(mark3);
        marks.add(mark4);
        marks.add(mark5);
    }

    public Mark findById(int id) {
        return  marks.stream()
                .filter(m -> m.getMarkId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Mark> getMarksForStudent(int studentId) {
        return marks.stream()
                .filter(m -> m.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    public List<Mark> findAll() {
        return marks;
    }

    public void createMark(Mark mark) {
        marks.add(mark);
    }

    public void deleteById(int id) {
        marks.removeIf(m -> m.getMarkId() == id);
    }
}
