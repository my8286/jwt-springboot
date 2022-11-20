package com.project.course.controller;

import com.project.course.dto.UserDto;
import com.project.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class RegistrationController {
    @Autowired
    private UserService userDetailsService;

    /**
     * This is the api to new user in db
     * @param userDto
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws SQLException {
        return ResponseEntity.ok(userDetailsService.save(userDto));
    }
}
