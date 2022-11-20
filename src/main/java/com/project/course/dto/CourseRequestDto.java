package com.project.course.dto;

import com.project.course.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseRequestDto {
    private Long courseId;
    private String title;
    private String description;
    private String videoUrl;
    private String topics;
    private String duration;
    private String category;
    private Status status;
}
