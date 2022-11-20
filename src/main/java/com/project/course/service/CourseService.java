package com.project.course.service;

import com.project.course.dto.CompletedCourseDto;
import com.project.course.dto.CourseRequestDto;
import com.project.course.enums.Status;
import com.project.course.model.Course;
import com.project.course.model.User;
import com.project.course.repository.CourseRepository;
import com.project.course.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.*;

@Service
@Slf4j
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    public Course courseCreateOrUpdate(CourseRequestDto courseRequestDto) {
        Course course = new Course();

        if (Objects.isNull(courseRequestDto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course details cannot be null");
        }

        if (!Objects.isNull(courseRequestDto.getCourseId())) {
            Optional<Course> courseOptional = courseRepository.findById(courseRequestDto.getCourseId());
            if (courseOptional.isPresent()) {
                course = courseOptional.get();
            }
            else{
                throw new RuntimeException("Course Id not found");
            }
        }

        return saveCourse(courseRequestDto, course);
    }

    private Course saveCourse(CourseRequestDto courseRequestDto, Course course) {
        if (!Objects.isNull(courseRequestDto.getTitle())) {
            course.setTitle(courseRequestDto.getTitle());
        }

        if(!Objects.isNull(courseRequestDto.getDescription())){
            course.setDescription(courseRequestDto.getDescription());
        }

        if(!Objects.isNull(courseRequestDto.getDuration())){
            course.setDuration(courseRequestDto.getDuration());
        }

        if(!Objects.isNull(courseRequestDto.getTopics())){
            course.setTopics(courseRequestDto.getTopics());
        }

        if(!Objects.isNull(courseRequestDto.getVideoUrl())){
            course.setVideoUrl(courseRequestDto.getVideoUrl());
        }

        if(!Objects.isNull(courseRequestDto.getCategory())){
            course.setCategory(courseRequestDto.getCategory());
        }

        if (Objects.isNull(courseRequestDto.getTitle())) {
            course.setTitle(courseRequestDto.getTitle());
        }

        return courseRepository.save(course);
    }

    public String deactivateCourse(CourseRequestDto courseRequestDto){

        if (Objects.isNull(courseRequestDto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course details cannot be null");
        }
        if (Objects.isNull(courseRequestDto.getCourseId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Course Id cannot be null");
        }
        else
        {
            Optional<Course> courseOptional = courseRepository.findById(courseRequestDto.getCourseId());
            if (courseOptional.isPresent()) {
                Course course = courseOptional.get();
                course.setStatus(Status.DEACTIVATED);
                courseRepository.save(course);
            }
            else{
                throw new RuntimeException("Course not found");
            }
        }
        return "Course is deleted successfully";
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public List<Course> getApprovedCourse() {
        return courseRepository.findCourses(Status.APPROVED);
    }

    public Course updateStatus(CourseRequestDto courseRequestDto) {
        if(Objects.isNull(courseRequestDto) || Objects.isNull(courseRequestDto.getCourseId()) || Objects.isNull(courseRequestDto.getStatus())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CourseId/Status cannot be null");
        }
        Optional<Course> courseOptional = courseRepository.findById(courseRequestDto.getCourseId());
        if(courseOptional.isPresent()){
            Course course=courseOptional.get();
            course.setStatus(courseRequestDto.getStatus());

            return courseRepository.save(course);
        }
        else{
            throw new RuntimeException("CourseId not found");
        }
    }

    public String completeCourseUpdate(CompletedCourseDto completedCourseDto) {

        if(Objects.isNull(completedCourseDto) || Objects.isNull(completedCourseDto.getCourseId()) || Objects.isNull(completedCourseDto.getUserId()))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"CourseId and userId cannot be null ");
        }
        Optional<User> userOptional = userRepository.findById(completedCourseDto.getUserId());
        if(userOptional.isPresent())
        {
            User user=userOptional.get();
            Optional<Course> courseOptional = courseRepository.findById(completedCourseDto.getUserId());
            if(courseOptional.isPresent())
            {
                Course course=courseOptional.get();
                Set<Course> courseSet=new HashSet<>();
                courseSet.add(course);
                user.setCourse(courseSet);
                userRepository.save(user);
            }
        }
        return "completed course updated successfully";

    }
}
