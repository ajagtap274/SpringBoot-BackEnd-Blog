package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJPA extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);
	

}
