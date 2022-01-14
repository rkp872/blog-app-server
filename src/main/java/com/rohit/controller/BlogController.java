package com.rohit.controller;

import com.rohit.entity.Blog;
import com.rohit.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    private List<Blog> getAllBlog(){
        return blogService.getAllBlog();
    }

    @GetMapping("/blog/{id}")
    private Blog getBlogById(@PathVariable("id") int id){
        return blogService.getBlogById(id);
    }

    @PostMapping("/blog")
    private Blog createBlog(@RequestBody Blog blog){
        return blogService.insertBlog(blog);
    }

    @DeleteMapping("/blog/{id}")
    private String deleteBlog(@PathVariable("id") int id){
        return blogService.deleteBlog(id);
    }

    @PutMapping("/blog/{id}")
    private String updateBlog(@PathVariable("id") int id, @RequestBody Blog blog){
        return blogService.updateBlog(id,blog);
    }
}
