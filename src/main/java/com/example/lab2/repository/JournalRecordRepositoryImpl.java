package com.example.lab2.repository;

import com.example.lab2.model.JournalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JournalRecordRepositoryImpl implements GenericRepository<JournalRecord>{

    @Override
    public JournalRecord findById(int id) {
        return null;
    }

    @Override
    public List<JournalRecord> findAll() {
        return null;
    }

    @Override
    public JournalRecord create(JournalRecord newEntity) {
        return null;
    }

    @Override
    public JournalRecord update(JournalRecord modifiedEntity) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
