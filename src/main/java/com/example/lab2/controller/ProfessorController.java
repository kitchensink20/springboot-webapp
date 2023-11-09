package com.example.lab2.controller;

import com.example.lab2.model.JournalRecord;
import com.example.lab2.model.Lesson;
import com.example.lab2.model.Professor;
import com.example.lab2.service.JournalRecordService;
import com.example.lab2.service.LessonService;
import com.example.lab2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/prof")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;
    @Autowired
    JournalRecordService journalRecordService;
    @Autowired
    LessonService lessonService;

    @GetMapping("/{profId}/all-lessons")
    public String getProfessorLessons(@PathVariable(value="profId") int profId,  Model model) {
        List<Lesson> lessons = lessonService.findLessonsByProfId(profId);
        model.addAttribute("lessons", lessons);
        return "professor-lessons-page";
    }

    @GetMapping("/all-students")
    public String displayAllStudents(Model model) {
        List<JournalRecord> records = journalRecordService.findAll();
        model.addAttribute("records", records);
        return "records-page";
    }

    @GetMapping("/all-profs")
    public String displayAllProfs(Model model) {
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professors", professors);
        return "profs-page";
    }

    @GetMapping("/about")
    public String displayAboutPage(Model model) {
        model.addAttribute("loggedIn", true);
        model.addAttribute("hasProfAccess", true);
        return "about-page";
    }
}
