package com.project.course.repository;

import com.project.course.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

	Optional<User> findById(Long id);
	
}