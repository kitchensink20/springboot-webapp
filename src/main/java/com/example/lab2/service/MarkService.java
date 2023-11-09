package com.example.lab2.service;

import com.example.lab2.model.Mark;
import com.example.lab2.repository.MarkRepositoryStub;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    private final MarkRepositoryStub markRepository;

    public MarkService(MarkRepositoryStub markRepository) {
        this.markRepository = markRepository;
    }

    public Mark findById(int id) {
        return  markRepository.findById(id);
    }

    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    public void createMark(Mark mark) {
        markRepository.createMark(mark);
    }

    public void deleteById(int id) {
        markRepository.deleteById(id);
    }
}
