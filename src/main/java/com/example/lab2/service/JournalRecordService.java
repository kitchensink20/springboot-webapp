package com.example.lab2.service;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.repository.JournalRecordRepositoryStub;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public Page<JournalRecord> findAll(Pageable pageable) {
        return journalRecordRepository.findAll(pageable);
    }

    public JournalRecord createRecord(JournalRecord student) {
        return journalRecordRepository.createRecord(student);
    }

    public JournalRecord updateRecord(JournalRecord student) {
        return journalRecordRepository.updateRecord(student);
    }

    public void deleteById(int id) {
        journalRecordRepository.deleteById(id);
    }
}
