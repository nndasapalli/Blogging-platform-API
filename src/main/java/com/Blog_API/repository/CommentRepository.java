package com.Blog_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_API.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findAllByBlogId(Long blogId);
}
