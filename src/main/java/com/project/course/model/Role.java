package com.project.course.model;



import com.project.course.enums.Roles;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "SET('ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN') default 'ROLE_USER'")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Roles name;

}
