package com.example.lab2.model;

import java.time.LocalDate;

public class JournalRecord {
    private final int studentId;
    private String fullName;
    private final LocalDate birthday;
    private boolean isFullTimeEducationForm;
    private String password;

    public JournalRecord(int studentId, String fullName, LocalDate birthday, boolean fullTimeEducationForm, String password) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.birthday = birthday;
        this.isFullTimeEducationForm = fullTimeEducationForm;
        this.password = password;
    }

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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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

