package com.project.course.controller;

import com.project.course.model.Course;
import com.project.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    CourseService courseService;

    @GetMapping("/get-course")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Course> getApprovedCourse() {

        return courseService.getApprovedCourse();
    }

}
