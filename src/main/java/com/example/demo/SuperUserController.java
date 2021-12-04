package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/super")
public class SuperUserController {
	@Autowired
	private SuperUserJpa userjpa;
	
	@GetMapping("/try")
	public String trial()
	{
		return "Tried...";
	}
	
	@GetMapping("/{username}/{password}")
	public int validateUser(@PathVariable String username,@PathVariable String password)
	{
		SuperUser u= userjpa.findByUsername(username);
		if(password.equals(u.getPassword()))
		{
			//System.out.println("Hello");
			return 1;
			
		}
		
		return 0;
	
	}
	

}
