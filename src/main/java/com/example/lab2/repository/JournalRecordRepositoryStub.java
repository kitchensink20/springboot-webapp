package com.example.lab2.repository;

import com.example.lab2.model.JournalRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JournalRecordRepositoryStub {
    private static List<JournalRecord> records = new ArrayList<JournalRecord>();

    static {
        JournalRecord record1 = new JournalRecord(1, "Ivan Tolkunov", LocalDate.of(2001, 7, 7),true, "jfesofjh2*");
        JournalRecord record2 = new JournalRecord(2, "Alina Lytovchenko", LocalDate.of(2004, 6, 20),true, "sgfsjmgflsrnf");
        JournalRecord record3 = new JournalRecord(3, "Maksym Bidnyi", LocalDate.of(2004, 2, 20),true, "jgfrwpifjrew");
        JournalRecord record4 = new JournalRecord(4, "Matylda Starzynska", LocalDate.of(1999, 5, 29),true, "kf;ewkjf");
        JournalRecord record5 = new JournalRecord(5, "Anna Ivasishyna", LocalDate.of(2004, 2, 23),true, "dkfpdswjfpkrswde");
        JournalRecord record6 = new JournalRecord(6, "<div class=\"container\">hallo</div>", LocalDate.of(2004, 2, 23),true, "dkfpdswjfpkdtgetrswde");
        records.add(record1);
        records.add(record2);
        records.add(record3);
        records.add(record4);
        records.add(record5);
        records.add(record6);
    }

    public JournalRecord findById(int id) {
        return  records.stream()
                .filter(s -> s.getStudentId() == id)
                .findFirst()
                .orElse(null);
    }

    public JournalRecord findByFullName(String fullName) {
        return records.stream()
                .filter(s -> s.getFullName().equals(fullName))
                .findFirst()
                .orElse(null);
    }

    public List<JournalRecord> findAll() {
        return records;
    }

    public void createRecord(JournalRecord student) {
        records.add(student);
    }

    public void updateRecord(JournalRecord student) {
        JournalRecord studentToUpdate = records.stream()
                .filter(s -> s.getStudentId() == student.getStudentId())
                .findAny().orElse(null);
        if(studentToUpdate != null) {
            studentToUpdate.setFullName(student.getFullName());
            studentToUpdate.setFullTimeEducationForm(student.isFullTimeEducationForm());
        }
    }

    public void deleteById(int id) {
        records.removeIf(s -> s.getStudentId() == id);
    }
}
