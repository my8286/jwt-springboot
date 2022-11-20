package com.project.course.repository;

import com.project.course.enums.Roles;
import com.project.course.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(Roles name);
}