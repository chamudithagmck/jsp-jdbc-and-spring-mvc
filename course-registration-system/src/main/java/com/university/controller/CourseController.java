package com.university.controller;

import com.university.dao.CourseDao;
import com.university.dao.RegistrationDao;
import com.university.model.Course;
import com.university.model.Student;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private RegistrationDao registrationDao;

    @GetMapping("/courses")
    public String listCourses(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) return "redirect:/login";

        List<Course> courses = courseDao.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (student == null) return "redirect:/login";

        registrationDao.registerStudent(student.getStudentId(), courseId);
        return "redirect:/success";
    }
}
