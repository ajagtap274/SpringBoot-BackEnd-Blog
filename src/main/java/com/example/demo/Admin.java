package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String fname;
	
	private String lname;
	
	private int age;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private Long Mobile;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile() {
		return Mobile;
	}

	public void setMobile(Long mobile) {
		Mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", Mobile=" + Mobile + "]";
	}

	
	

	
	
}
