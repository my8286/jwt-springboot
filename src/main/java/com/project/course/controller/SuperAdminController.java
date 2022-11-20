package com.project.course.controller;

import com.project.course.dto.CourseRequestDto;
import com.project.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("super-admin")
public class SuperAdminController {
    @Autowired
    CourseService courseService;

    /**
     * This is the api to fetch all courses from db
     * @return
     */
    @GetMapping("/get-all-course")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public ResponseEntity<List<?>> getAllCourse()
    {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    /**
     * This is the api to update the status of a particular course
     * @param courseRequestDto
     * @return
     */
    @PostMapping("/update/status")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity<?> updateStatus(@RequestBody CourseRequestDto courseRequestDto)
    {
        return ResponseEntity.ok(courseService.updateStatus(courseRequestDto));
    }
}
