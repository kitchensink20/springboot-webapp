package com.example.lab2.restContoller;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.service.JournalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/journalRecords")
public class JournalRecordController {
    @Autowired
    private JournalRecordService journalRecordService;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JournalRecord> getJournalRecordById(@PathVariable int id) {
        JournalRecord foundJournalRecord = journalRecordService.findById(id);
        if(foundJournalRecord != null)
            return new ResponseEntity<>(foundJournalRecord, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public Page<JournalRecord> getAllJournalRecords(
            @RequestParam(defaultValue =  "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return journalRecordService.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    public ResponseEntity<JournalRecord> createJournalRecord(@RequestBody NewJournalRecordRequest journalRecord) {
        try {
            System.out.println();
            JournalRecord newJournalRecord = new JournalRecord();
            newJournalRecord.setStudentId(journalRecord.studentId);
            newJournalRecord.setFullName(journalRecord.fullName);
            newJournalRecord.setBirthday(journalRecord.birthday);
            newJournalRecord.setFullTimeEducationForm(journalRecord.isFullTimeEducationForm);
            newJournalRecord.setPassword(journalRecord.password);
            journalRecordService.createRecord(newJournalRecord);
            return new ResponseEntity<>(newJournalRecord, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalRecord> updateJournalRecord(@PathVariable int id,
                                                             @RequestBody NewJournalRecordRequest journalRecordDetails) {
        JournalRecord journalRecord = journalRecordService.findById(id);
        if(journalRecord == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        journalRecord.setFullName(journalRecordDetails.fullName);
        journalRecord.setBirthday(journalRecordDetails.birthday);
        journalRecord.setFullTimeEducationForm(journalRecordDetails.isFullTimeEducationForm);
        journalRecord.setPassword(journalRecordDetails.password);

        try{
            JournalRecord updatedJournalRecord = journalRecordService.updateRecord(journalRecord);
            return new ResponseEntity<>(updatedJournalRecord, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JournalRecord> deleteJournalRecord(@PathVariable int id) {
        try {
            journalRecordService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    record NewJournalRecordRequest(
            int studentId,
            String fullName,
            LocalDate birthday,
            boolean isFullTimeEducationForm,
            String password
    ) { }
}
