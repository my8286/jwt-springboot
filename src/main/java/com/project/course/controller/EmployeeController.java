package com.project.course.controller;

import com.project.course.dto.CompletedCourseDto;
import com.project.course.model.Course;
import com.project.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    CourseService courseService;

    /**
     * To get all approved courses from db
     * @return
     */
    @GetMapping("/get-course")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Course>> getApprovedCourse() {

        return ResponseEntity.ok(courseService.getApprovedCourse());
    }

    /**
     * completed course update
     * @return
     */
    @PostMapping("/complete")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> completeCourseUpdate(@RequestBody CompletedCourseDto completedCourseDto) {

        return ResponseEntity.ok(courseService.completeCourseUpdate(completedCourseDto));
    }

}
