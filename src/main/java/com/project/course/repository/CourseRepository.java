package com.project.course.repository;

import com.project.course.enums.Status;
import com.project.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = " FROM Course c " +
            "WHERE c.status=:status ", nativeQuery = false)
    List<Course> findCourses(@Param("status") Status status);

//
//    List<Course> findByStatus(Status published);
//
//    @Query(value="Select * from course where status=?1 and user_id=?2",nativeQuery = true)
//    List<Course> findByStatusAndUserId(String status, Long userId);
}
