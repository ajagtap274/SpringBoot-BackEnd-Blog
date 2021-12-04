package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserJPA userjpa;
	
	@GetMapping("/try")
	public String trial()
	{
		return "Tried...";
	}
	
	@GetMapping("/{username}/{password}")
	public int validateUser(@PathVariable String username,@PathVariable String password)
	{
		User u= userjpa.findByUsername(username);
		if(password.equals(u.getPassword()))
		{
			//System.out.println("Hello");
			return 1;
			
		}
		
		return 0;
	
	}
	
	
	
	@PostMapping("/create/user")
	public void createUser(@RequestBody User user)
	{
		userjpa.save(user);
	}
	
	
	
	

}
