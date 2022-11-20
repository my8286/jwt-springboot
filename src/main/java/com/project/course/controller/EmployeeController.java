package com.project.course.controller;

import com.project.course.model.Course;
import com.project.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    CourseService courseService;

    @GetMapping("/get-course")
    public List<Course> getUserBlogs() {

        return courseService.getApprovedCourse();
    }

}
