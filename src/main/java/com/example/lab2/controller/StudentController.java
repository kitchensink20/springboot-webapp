package com.example.lab2.controller;

import com.example.lab2.model.Mark;
import com.example.lab2.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    MarkService markService;

    @GetMapping("/all-marks")
    public String displayAllMarksForStudent(Model model) {
        List<Mark> marks = markService.findAll();
        model.addAttribute("marks", marks);
        return "student-marks-page";
    }

    @GetMapping("/about")
    public String displayAboutPage(Model model) {
        model.addAttribute("loggedIn", true);
        model.addAttribute("hasStudentAccess", true);
        return "about-page";
    }
}
