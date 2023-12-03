package com.example.lab2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class JournalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String fullName;
    private LocalDate birthday;
    private boolean isFullTimeEducationForm;
    private String password;

    public JournalRecord(int studentId, String fullName, LocalDate birthday, boolean fullTimeEducationForm, String password) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthday = birthday;
        this.isFullTimeEducationForm = fullTimeEducationForm;
        this.password = password;
    }

    public JournalRecord() { }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public boolean isFullTimeEducationForm() {
        return isFullTimeEducationForm;
    }

    public String getPassword() { return password; }

    public void setStudentId(int studentId) { this.studentId = studentId; }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public void setFullTimeEducationForm(boolean isFullTimeEducationForm) {
        this.isFullTimeEducationForm = isFullTimeEducationForm;
    }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "JournalRecord{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", isFullTimeEducationForm=" + isFullTimeEducationForm +
                '}';
    }
}

