package com.project.course.service;

import com.project.course.enums.Roles;
import com.project.course.model.Role;
import com.project.course.repository.UserRepository;
import com.project.course.model.User;
import com.project.course.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getRoles(user));
	}

	public List<GrantedAuthority> getRoles(User user){
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return authorities;
	}
	
	public String registerUser(UserDto userDto) {
		User userOptional = userRepository.findByUsername(userDto.getUsername());
		if (!Objects.isNull(userOptional)) {
			return "username already exist";
		}
		User user = new User();

		Role role = roleService.findByName(Roles.ROLE_USER);
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);

		user.setUsername(userDto.getUsername());
		user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
		user.setRoles(roleSet);
		userRepository.save(user);
		return "user registered successfully";
	}
}