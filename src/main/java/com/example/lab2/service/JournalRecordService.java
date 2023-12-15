package com.example.lab2.service;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.repository.JournalRecordRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalRecordService {
    private final JournalRecordRepositoryImpl journalRecordRepository;

    public JournalRecordService(JournalRecordRepositoryImpl journalRecordRepository) {
        this.journalRecordRepository = journalRecordRepository;
    }

    public JournalRecord findById(int id) {
        return  journalRecordRepository.findById(id);
    }

    public List<JournalRecord> findAll() {
        return journalRecordRepository.findAll();
    }

    public JournalRecord createRecord(JournalRecord student) {
        return journalRecordRepository.create(student);
    }

    public JournalRecord updateRecord(JournalRecord student) {
        return journalRecordRepository.update(student);
    }

    public void deleteById(int id) {
        journalRecordRepository.deleteById(id);
    }
}
