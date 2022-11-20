package com.project.course.controller;

import com.project.course.dto.CourseRequestDto;
import com.project.course.model.Course;
import com.project.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("admin/course")
public class AdminController {

    @Autowired
    CourseService courseService;

    /**
     * This is the api to add or update the course details
     * @param courseRequestDto
     * @return
     */
    @PostMapping("/create-update")
    public ResponseEntity<Course> courseCreateOrUpdate(@RequestBody CourseRequestDto courseRequestDto)
    {
        return ResponseEntity.ok(courseService.courseCreateOrUpdate(courseRequestDto));
    }

    /**
     * This is the api to delete/deactivate a paticular course if required
     * @param courseRequestDto
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity<?> deactivateCourse(@RequestBody CourseRequestDto courseRequestDto)
    {
        return ResponseEntity.ok(courseService.deactivateCourse(courseRequestDto));
    }


}
