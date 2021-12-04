package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperUserJpa extends JpaRepository<SuperUser, Long> {
	public SuperUser findByUsername(String username);

}
