package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AdminService {
	
	@Autowired
	private AdminJPA adminJpa;
	
	  @Transactional
	    public void createAdmin(AdminDto adminDto) {
	        Admin admin = mapFromDtoToAdmin(adminDto);
	        adminJpa.save(admin);
	    }

	
	
	 private Admin mapFromDtoToAdmin(AdminDto adminDto) {
	        Admin admin = new Admin();
	        admin.setFname(adminDto.getFname());
	        admin.setLname(adminDto.getLname());
	        admin.setEmail(adminDto.getEmail());
	        admin.setAge(adminDto.getAge());
	        admin.setUsername(adminDto.getUsername());
	        admin.setPassword(adminDto.getPassword());
	        admin.setMobile(adminDto.getMobile());

	        return admin;
	    }
	 
		public int validateAdmin(String username,String password)
		{
			Admin a = adminJpa.findByUsername(username);
			if(password.equals(a.getPassword()))
			{
				//System.out.println("Hello");
				return 1;
				
			}
			
			return 0;
		
		}
}
