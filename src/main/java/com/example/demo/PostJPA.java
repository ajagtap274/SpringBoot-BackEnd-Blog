package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPA extends JpaRepository<Post, Long> {
	
}