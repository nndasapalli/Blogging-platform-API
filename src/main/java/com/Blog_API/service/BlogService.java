package com.Blog_API.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog_API.entity.Blog;
import com.Blog_API.entity.User;
import com.Blog_API.repository.BlogRepository;
import com.Blog_API.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Blog createBlog(Blog blog, Long userId) {
		User author = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		blog.setAuthor(author);
		blog.setCreatedAt(LocalDateTime.now());
		blog.setUpdatedAt(LocalDateTime.now());
		return blogRepository.save(blog);
	}

	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	public Blog getBlogById(Long id) {
		return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
	}

	public Blog updateBlog(Long id, Blog updatedBlog) {
		Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));

		existingBlog.setTitle(updatedBlog.getTitle());
		existingBlog.setContent(updatedBlog.getContent());
		existingBlog.setTags(updatedBlog.getTags());
		existingBlog.setUpdatedAt(LocalDateTime.now());

		return blogRepository.save(existingBlog);
	}

	public void deleteBlog(Long id) {
		Blog existingBlog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
		blogRepository.deleteById(existingBlog.getId());		
	}
}
