package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.persistence.criteria.Path;
import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

@CrossOrigin("http://localhost:4200")
@RestController
public class imageController {

//	
	
	@Autowired
	private imageHelper imgH;
	
	
	//ResponseEntity<String>			ResponseEntity.ok("Success");
    @PostMapping(value="/upload")
    public String uploadImg(@RequestParam("file") MultipartFile file)
    {
    	System.out.println("**************Requested****************");
    	System.out.println(file.getClass().getSimpleName());
    	System.out.println(file.getOriginalFilename());
    	
    	if(file==null)
    	{
    		return ("Null File");
    	}
    	
    	
    	
    	try {
    		
    		boolean b=imgH.uploadFile(file);
    		if(b==true)
    		{
    			return file.getOriginalFilename();
    		}
    		else
    		{
    			return ("Something went wrong");
    		}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    	
    	
    	return ("WORKING");
    }
  }
