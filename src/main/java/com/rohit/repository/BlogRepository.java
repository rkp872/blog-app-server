package com.rohit.repository;

import com.rohit.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    public List<Blog> findAllByOrderByIdDesc();
}
