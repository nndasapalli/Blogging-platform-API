package com.Blog_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_API.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
