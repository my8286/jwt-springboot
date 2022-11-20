package com.project.course.model;



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

    @Column(columnDefinition = "SET('ROLE_ADMIN','ROLE_USER','PUBLISHED') default 'ROLE_USER'")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private com.project.course.enums.Role role;

}
