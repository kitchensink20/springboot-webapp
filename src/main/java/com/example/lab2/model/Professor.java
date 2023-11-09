package com.example.lab2.model;

import java.util.Objects;

public class Professor {
    private final int professorId;
    private String fullName;
    private String position;
    private String password;

    public Professor(int professorId, String fullName, String position, String password) {
        this.professorId = professorId;
        this.fullName = fullName;
        this.position = position;
        this.password = password;
    }

    public int getProfessorId() {
        return professorId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPassword() { return password; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
