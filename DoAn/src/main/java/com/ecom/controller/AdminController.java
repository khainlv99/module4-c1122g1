package com.ecom.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import com.ecom.model.Grade;
import com.ecom.model.Student;
import com.ecom.model.Subject;
import com.ecom.service.GradeService;
import com.ecom.service.StudentService;
import com.ecom.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.UserDtls;
import com.ecom.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private GradeService gradeService;

	// Trang chính của Admin
	@GetMapping("/")
	public String index() {
		return "admin/index";
	}

	// Quản lý người dùng
	@GetMapping("/users")
	public String getAllUsers(Model m) {
		List<UserDtls> users = userService.getUsers("ROLE_USER");
		m.addAttribute("users", users);
		return "admin/users";
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

	@GetMapping("/updateSts")
	public String updateUserAccountStatus(@RequestParam Boolean status, @RequestParam Integer id, HttpSession session) {
		Boolean f = userService.updateAccountStatus(id, status);
		if (f) {
			session.setAttribute("succMsg", "Đã cập nhật trạng thái tài khoản");
		} else {
			session.setAttribute("errorMsg", "Đã xảy ra lỗi trên máy chủ");
		}
		return "redirect:/admin/users";
	}

	// Quản lý sinh viên

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "admin/students";
	}

	@GetMapping("/students/add")
	public String showAddStudentForm(Model model) {
		model.addAttribute("student", new Student());
		List<Subject> subjects = subjectService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "admin/add_student";
	}

	// Method to handle form submission
	@PostMapping("/students/add")
	public String addStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/admin/students";
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/admin/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		List<Subject> subjects = subjectService.getAllSubjects();
		model.addAttribute("student", student);
		model.addAttribute("subjects", subjects);
		return "admin/edit_student";
	}

	@PostMapping("/students/update")
	public String updateStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/admin/students";
	}

	@GetMapping("/students/search")
	public String searchStudents(@RequestParam String name, Model model) {
		model.addAttribute("students", studentService.searchStudentsByName(name));
		return "admin/students";
	}
	@GetMapping("/students/details/{id}")
	public String viewStudentDetails(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "user/student_details"; // Make sure this matches the Thymeleaf template name
	}

	// Quản lý môn học
	@GetMapping("/subjects")
	public String getAllSubjects(Model model) {
		model.addAttribute("subjects", subjectService.getAllSubjects());
		return "admin/subjects";
	}

	@PostMapping("/subjects/add")
	public String addSubject(@ModelAttribute Subject subject, HttpSession session) {
		subjectService.saveSubject(subject);
		session.setAttribute("succMsg", "Subject added successfully");
		return "redirect:/admin/subjects";
	}

	@GetMapping("/subjects/delete/{id}")
	public String deleteSubject(@PathVariable Long id, HttpSession session) {
		subjectService.deleteSubject(id);
		session.setAttribute("succMsg", "Subject deleted successfully");
		return "redirect:/admin/subjects";
	}

	@GetMapping("/subjects/edit/{id}")
	public String editSubject(@PathVariable Long id, Model model) {
		Subject subject = subjectService.getSubjectById(id);
		model.addAttribute("subject", subject);
		return "admin/edit_subject";
	}

	@PostMapping("/subjects/update")
	public String updateSubject(@ModelAttribute Subject subject, HttpSession session) {
		subjectService.saveSubject(subject);
		session.setAttribute("succMsg", "Subject updated successfully");
		return "redirect:/admin/subjects";
	}

	// Quản lý điểm
	@GetMapping("/grades")
	public String getAllGrades(Model model) {
		List<Grade> grades = gradeService.getAllGrades();
		List<Student> students = studentService.getAllStudents();
		List<Subject> subjects = subjectService.getAllSubjects();

		model.addAttribute("grades", grades);
		model.addAttribute("students", students);
		model.addAttribute("subjects", subjects);

		return "admin/grades";
	}

	@PostMapping("/grades/add")
	public String addGrade(@RequestParam Long studentId, @RequestParam Long subjectId, @RequestParam Double grade) {
		Student student = studentService.getStudentById(studentId);
		Subject subject = subjectService.getSubjectById(subjectId);

		Grade newGrade = new Grade();
		newGrade.setStudent(student);
		newGrade.setSubject(subject);
		newGrade.setGrade(grade);

		gradeService.saveGrade(newGrade);
		return "redirect:/admin/grades";
	}

	@GetMapping("/grades/delete/{id}")
	public String deleteGrade(@PathVariable Long id) {
		gradeService.deleteGrade(id);
		return "redirect:/admin/grades";
	}

	@GetMapping("/grades/edit/{id}")
	public String editGrade(@PathVariable Long id, Model model) {
		Grade grade = gradeService.getGradeById(id);
		System.out.println("Editing Grade ID: " + id);  // Log the grade ID
		if (grade == null) {
			System.out.println("Grade not found");
			return "redirect:/admin/grades";
		}
		List<Subject> subjects = subjectService.getAllSubjects();
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("grade", grade);
		model.addAttribute("students", students);
		model.addAttribute("subjects", subjects);
		return "admin/edit_grade";
	}

	@PostMapping("/grades/update")
	public String updateGrade(@RequestParam Long id,
							  @RequestParam Long studentId,
							  @RequestParam Long subjectId,
							  @RequestParam Double grade) {  // Đảm bảo đây là Double
		Student student = studentService.getStudentById(studentId);
		Subject subject = subjectService.getSubjectById(subjectId);

		Grade updatedGrade = new Grade();
		updatedGrade.setId(id);
		updatedGrade.setStudent(student);
		updatedGrade.setSubject(subject);
		updatedGrade.setGrade(grade);
		gradeService.saveGrade(updatedGrade);
		return "redirect:/admin/grades";
	}
}
