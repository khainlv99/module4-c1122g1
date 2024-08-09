package com.ecom.controller;

import com.ecom.model.Grade;
import com.ecom.model.Subject;
import com.ecom.model.UserDtls;
import com.ecom.service.GradeService;
import com.ecom.service.StudentService;
import com.ecom.service.SubjectService;
import com.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index() {
        return "teacher/index";
    }
    @ModelAttribute
    public void getUserDetails(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            UserDtls userDtls = userService.getUserByEmail(email);
            System.out.println("User Details: " + userDtls); // Log user details
            m.addAttribute("user", userDtls);
        }
    }

    // View grades
    @GetMapping("/grades")
    public String viewGrades(Model model) {
        List<Grade> grades = gradeService.getAllGrades(); // Filter if necessary for the specific teacher
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("grades", grades);
        model.addAttribute("subjects", subjects);
        return "teacher/grades"; // Create this view for displaying grades
    }

    // Manage courses
    @GetMapping("/courses")
    public String manageCourses(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "teacher/courses"; // Create this view for managing courses
    }
    @GetMapping("/reports")
    public String viewReports(Model model) {
        // Fetch data for reports, such as grade summaries
        List<Grade> grades = gradeService.getAllGrades();
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("grades", grades);
        model.addAttribute("subjects", subjects);

        // Here you can add logic to process or summarize the data for the report
        return "teacher/reports"; // Create this view for displaying reports
    }
}
