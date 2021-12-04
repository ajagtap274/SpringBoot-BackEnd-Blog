package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admins/")
public class AdminController {
	
	@Autowired
	private AdminService adminSer;
    @Autowired
    private AdminJPA adminJpa;
	
    
    @PostMapping("/create")
    public ResponseEntity createAdmin(@RequestBody AdminDto adminDto) {
    	 adminSer.createAdmin(adminDto);
    	 System.out.println("Admin created");
    	return new ResponseEntity(HttpStatus.OK);
    }
    
    @GetMapping("/{username}/{password}")
	public int validateAdmin(@PathVariable String username,@PathVariable String password)
	{
    	int res=adminSer.validateAdmin(username, password);
    	return res;
	}
}
