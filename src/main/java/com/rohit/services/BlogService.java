package com.rohit.services;

import com.rohit.entity.Blog;
import com.rohit.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlog(){
        return blogRepository.findAllByOrderByIdDesc();
    }
    public Blog getBlogById(int id){
        return blogRepository.findById(id).get();
    }
    public Blog insertBlog(Blog blog){
        return blogRepository.save(blog);
    }
    public String deleteBlog(int id){
        Blog blogToDelete=blogRepository.findById(id).get();
        if(blogToDelete==null){
            return "Invalid Id";
        }
        blogRepository.delete(blogToDelete);
        return "Blog deleted successfully";
    }
    public String updateBlog(int id,Blog updatedBlog){
        Blog alreadyExistingBlog=blogRepository.findById(id).get();
        if(alreadyExistingBlog!=null){
            updatedBlog.setId(alreadyExistingBlog.getId());
            blogRepository.save(updatedBlog);
            return "Blog Updated";
        }
        else {
            return "Blog with given Id is not found";
        }
    }
}

