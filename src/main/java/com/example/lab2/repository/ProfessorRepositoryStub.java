package com.example.lab2.repository;

import com.example.lab2.model.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepositoryStub {
    private static List<Professor> professors = new ArrayList<Professor>();

    static {
        Professor professor1 = new Professor(1, "Svitlana Proskura", "Dean", "fkdspfkj");
        Professor professor2 = new Professor(2, "Yaroslav Kornaga", "Professor", "kfsdpfjs");
        Professor professor3 = new Professor(3, "Yevgeniy Vovk", "Professor", "krwfgjpsr");
        Professor professor4 = new Professor(4, "Yuliia Kuliasha", "Professor", "dkfpsd[okf");
        Professor professor5 = new Professor(5, "Volodymyr Popenko", "Professor", "fsg[skfd");
        professors.add(professor1);
        professors.add(professor2);
        professors.add(professor3);
        professors.add(professor4);
        professors.add(professor5);
    }

    public Professor findById(int id) {
        return  professors.stream()
                .filter(prof -> prof.getProfessorId() == id)
                .findFirst()
                .orElse(null);
    }

    public Professor findByFullName(String fullName) {
        return professors.stream()
                .filter(prof -> prof.getFullName().equals(fullName))
                .findFirst()
                .orElse(null);
    }

    public List<Professor> findAll() {
        return professors;
    }

    public void createProfessor(Professor professor) {
        professors.add(professor);
    }

    public void updateProfessor(Professor professor) {
        Professor profToUpdate = professors.stream()
                .filter(prof -> prof.getProfessorId() == professor.getProfessorId())
                .findAny().orElse(null);
        if(profToUpdate != null) {
            profToUpdate.setFullName(professor.getFullName());
            profToUpdate.setPosition(professor.getPosition());
        }
    }

    public void deleteById(int id) {
        professors.removeIf(prof -> prof.getProfessorId() == id);
    }
}
