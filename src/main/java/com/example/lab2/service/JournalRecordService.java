package com.example.lab2.service;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.repository.JournalRecordRepositoryStub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalRecordService {
    private final JournalRecordRepositoryStub journalRecordRepository;

    public JournalRecordService(JournalRecordRepositoryStub journalRecordRepository) {
        this.journalRecordRepository = journalRecordRepository;
    }

    public JournalRecord findById(int id) {
        return  journalRecordRepository.findById(id);
    }

    public JournalRecord findByFullName(String fullName) {
        return journalRecordRepository.findByFullName(fullName);
    }

    public List<JournalRecord> findAll() {
        return journalRecordRepository.findAll();
    }

    public void createRecord(JournalRecord student) {
        journalRecordRepository.createRecord(student);
    }

    public void updateRecord(JournalRecord student) {
        journalRecordRepository.updateRecord(student);
    }

    public void deleteById(int id) {
        journalRecordRepository.deleteById(id);
    }
}
