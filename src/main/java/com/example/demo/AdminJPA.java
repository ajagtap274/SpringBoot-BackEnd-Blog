package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJPA extends JpaRepository<Admin, Long> {
	public Admin findByUsername(String username);
	

}
