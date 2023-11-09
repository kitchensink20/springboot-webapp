package com.example.lab2.model;

import java.time.LocalDate;

public class Mark {
    private final int markId;
    private final int studentId;
    private final int lessonId;
    private final LocalDate date;
    private final int mark;

    public Mark(int markId, int studentId, int lessonId, LocalDate date, int mark) {
        this.markId = markId;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.date = date;
        this.mark = mark;
    }

    public int getMarkId() { return markId; }

    public int getStudentId() {
        return studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", studentId=" + studentId +
                ", lessonId=" + lessonId +
                ", date=" + date +
                ", mark=" + mark +
                '}';
    }
}
