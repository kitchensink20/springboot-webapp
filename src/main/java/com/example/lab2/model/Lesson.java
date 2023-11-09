package com.example.lab2.model;

public class Lesson {
    private final int lessonId;
    private final String subjectName;
    private final int professorId;
    private final String weekDay;
    private final int classNumber;

    public Lesson(int lessonId, String subjectName, int professorId, String weekDay, int classNumber) {
        this.lessonId = lessonId;
        this.professorId = professorId;
        this.subjectName = subjectName;
        this.weekDay = weekDay;
        this.classNumber = classNumber;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getProfessorId() {
        return professorId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public String getWeekDay() {
        return weekDay;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", subjectName='" + subjectName + '\'' +
                ", professorId=" + professorId +
                ", weekDay='" + weekDay + '\'' +
                ", classNumber=" + classNumber +
                '}';
    }
}
