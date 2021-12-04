package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cats/")
public class CatController {

	
	@Autowired
	private CatJPA catJpa;
	
	
	@PostMapping("/create/cat")
	public void createCat(@RequestBody String categ)
	{
		Categories cat= new Categories();
		cat.setCategory(categ);
		catJpa.save(cat);
	}
	
	 @GetMapping("/all")
	 public List<Categories> getCats()
	 {
		 return catJpa.findAll();
	 }
	 
	 @GetMapping("/get/{id}")
	 public Categories getSingleCat(@PathVariable @RequestBody Long id) throws ClassNotFoundException 
	 {
		 Categories c=catJpa.findById(id).orElseThrow(() -> new ClassNotFoundException("For id " + id));
		 return c;
	 }
	 
	 @DeleteMapping("/del/{id}")
	 public void deleteCat(@PathVariable @RequestBody Long id)
	 {
		 catJpa.deleteById(id);
	 }
	 
	 
	 
	 
}
