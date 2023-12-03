package com.example.lab2.restContoller;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.service.JournalRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/journalRecords")
@Tag(name = "Journal Records")
public class JournalRecordController {
    @Autowired
    private JournalRecordService journalRecordService;

    @Operation (
            description = "Gets journal record by ID, ID needs to be specified in URL.",
            summary = "Get journal record by ID",
            responses =  {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name =  "ExampleJournalRecord",
                                            value = "{\"studentId\": 1, \"fullName\": \"Ivan Tolkunov\", \"birthday\": \"2001-07-07\", \"isFullTimeEducationForm\": true, \"password\": \"hashed\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content(
                                mediaType = "application/json",
                                examples = @ExampleObject(
                                    name = "NotFoundResponse",
                                    value = ""
                                )
                            )
                    )
            }
    )
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JournalRecord> getJournalRecordById(
            @ApiParam(
                    name = "id",
                    value = "ID of the journal record.",
                    type = "integer",
                    example = "2",
                    required = true)
            @PathVariable int id) {
        JournalRecord foundJournalRecord = journalRecordService.findById(id);
        if(foundJournalRecord != null)
            return new ResponseEntity<>(foundJournalRecord, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation (
            description = "Gets all journal records, data can be returned partially due to specifying page number and page size.",
            summary = "Get all journal records with pagination",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping
    public Page<JournalRecord> getAllJournalRecords(
            @ApiParam(name = "pageNumber",
                        value = "Number of the page.",
                        type = "integer",
                        example = "3")
            @RequestParam(defaultValue =  "0") int page,
            @ApiParam(name = "pageSize",
                    value = "Size of the page.",
                    type = "integer",
                    example = "2")
            @RequestParam(defaultValue = "10") int size) {
        return journalRecordService.findAll(PageRequest.of(page, size));
    }

    @Operation (
            description = "Gets journal records filtered by name, ID needs to be specified in reguest param.",
            summary = "Get journal records filtered by name",
            responses =  {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name =  "ExampleJournalRecord",
                                            value = "[{\"studentId\": 1, \"fullName\": \"Ivan Tolkunov\", \"birthday\": \"2001-07-07\", \"isFullTimeEducationForm\": true, \"password\": \"hashed\" }," +
                                                    "{\"studentId\": 8, \"fullName\": \"Ivan Sikorsku\", \"birthday\": \"2001-02-01\", \"isFullTimeEducationForm\": true, \"password\": \"hashed\" }]"
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name = "NotFoundResponse",
                                            value = ""
                                    )
                            )
                    )
            }
    )
    @GetMapping(value = "/filterByName", produces = "application/json")
    public ResponseEntity<List<JournalRecord>> getAllJournalRecordsFilteredByName(
            @ApiParam(name = "studentName",
                    value = "Student's name.",
                    type = "string",
                    example = "Ivan")
            @RequestParam String name) {
        List<JournalRecord> filteredJournalRecords = journalRecordService.filterByName(name);

        if(filteredJournalRecords.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(filteredJournalRecords, HttpStatus.OK);
    }

    @Operation (
            description = "Creates new journal record in the database.",
            summary = "Create journal record",
            responses = {
                    @ApiResponse(
                            description = "CREATED",
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name =  "ExampleJournalRecord",
                                            value = "{\"studentId\": 7, \"fullName\": \"Ivan Tolkunov\", \"birthday\": \"2001-07-07\", \"isFullTimeEducationForm\": true, \"password\": \"hashed\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "BAD REQUEST",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name = "BadRequest",
                                            value = ""
                                    )
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<JournalRecord> createJournalRecord(
            @ApiParam(value = "Object that needs to be added to the database", required = true)
            @RequestBody NewJournalRecordRequest journalRecord) {
        try {
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

    @Operation (
            description = "Updates existing journal record in the database by ID.",
            summary = "Update existing journal record",
            responses = {
                    @ApiResponse(
                            description = "OK",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name =  "ExampleJournalRecord",
                                            value = "{\"studentId\": 3, \"fullName\": \"Ivan Tolkunov\", \"birthday\": \"2001-07-07\", \"isFullTimeEducationForm\": true, \"password\": \"hashed\" }"
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "INTERNAL SERVER ERROR",
                            responseCode = "503",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name = "InternalServerError",
                                            value = ""
                                    )
                            )
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<JournalRecord> updateJournalRecord(
            @ApiParam(
                    value = "ID of the journal record that needs to be updated.",
                    name = "id",
                    type = "integer",
                    example = "2",
                    required = true)
            @PathVariable int id,
            @ApiParam(value = "Modified version of the object.", required = true)
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

    @Operation (
            description = "Delete existing journal record in the database by ID.",
            summary = "Delete existing journal record",
            responses = {
                    @ApiResponse(
                            description = "NO CONTENT",
                            responseCode = "204",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name = "NoContentResponse",
                                            value = ""
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "INTERNAL SERVER ERROR",
                            responseCode = "503",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            name = "InternalServerError",
                                            value = ""
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<JournalRecord> deleteJournalRecord(
            @ApiParam(
                    name = "id",
                    value = "ID of the journal record.",
                    type = "integer",
                    example = "2",
                    required = true)
            @PathVariable int id) {
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
