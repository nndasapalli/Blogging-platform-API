package com.Blog_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_API.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long>{

}
