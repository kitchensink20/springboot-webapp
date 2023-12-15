package com.example.lab2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markId;
    private int studentId;
    private int lessonId;
    private LocalDate date;
    private int mark;

    public Mark(int markId, int studentId, int lessonId, LocalDate date, int mark) {
        this.markId = markId;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.date = date;
        this.mark = mark;
    }

    public Mark() { }

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

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
