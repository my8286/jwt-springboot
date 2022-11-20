package com.project.course.model;

import com.project.course.enums.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String description;

    @Column
    @Getter
    @Setter
    private String videoUrl;

    @Column
    @Getter
    @Setter
    private String duration;

    @Column
    @Getter
    @Setter
    private String topics;

    @Column
    @Getter
    @Setter
    private String category;

    @Column(columnDefinition = "SET('CREATED','DEACTIVATED','APPROVED','UPDATED') default 'CREATED'")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Status status;

}
