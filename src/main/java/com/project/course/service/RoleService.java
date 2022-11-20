package com.project.course.service;

import com.project.course.dto.UserDto;
import com.project.course.enums.Roles;
import com.project.course.model.Role;
import com.project.course.model.User;
import com.project.course.repository.RoleRepository;
import com.project.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;


	public Role findByName(Roles name) {
		return roleRepository.findByName(name);
	}
}