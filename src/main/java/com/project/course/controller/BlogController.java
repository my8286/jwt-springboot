package com.project.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/add-blog")
    public ResponseEntity<?> addBlog(@RequestBody BlogDto blogDto)
    {
        return ResponseEntity.ok(blogService.addBlog(blogDto));
    }

    @PostMapping("/update-blog")
    public ResponseEntity<?> updateBlog(@RequestBody BlogDto blogDto)
    {
        return ResponseEntity.ok(blogService.updateBlog(blogDto));
    }
//    @GetMapping("/get-blogs")
//    public List<Blog> getBlogs(){
//        return blogService.getblogs();
//    }

    @GetMapping("/get-user-blogs")
    public List<Blog> getUserBlogs(@RequestParam String status, @RequestParam String username , @RequestParam String role){
        return blogService.getUserBlogs(status, username, role);
    }

}
