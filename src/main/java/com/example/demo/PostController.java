package com.example.demo;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.*;

import javax.imageio.ImageIO;
import javax.persistence.criteria.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/posts/")
public class PostController {

	@Autowired
	private PostService postSer;
    @Autowired
    private PostJPA postJPA;

    @PostMapping("/post")
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
    	System.out.println("************Someone Posted**********");
        postSer.createPost(postDto);
        System.out.println("Success");
        System.out.println("Category:"+postDto.getCategory());
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PostMapping("/postAll")
//    public ResponseEntity createPosts(@RequestBody List<Post> posts) {
//    	postJPA.saveAll(posts);
////        postJPA.saveAll(posts);
//        return new ResponseEntity(HttpStatus.OK);
//    }
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
    	 return new ResponseEntity<>(postSer.showAllPosts(), HttpStatus.OK);
      //  return new ResponseEntity<>(postJPA.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Post> getSinglePost(@PathVariable @RequestBody Long id) throws ClassNotFoundException {
        return new ResponseEntity(postSer.readSinglePost(id), HttpStatus.OK);
    }
  
//    @PutMapping("/inc/{id}")
//    public void incViews(@PathVariable Long id) throws ClassNotFoundException
//    {
//    	postSer.incViewPost(id);
//    	
//    }
    
    @DeleteMapping ("/del/{id}")
    public void delSinglePost(@PathVariable @RequestBody Long id) throws ClassNotFoundException {
        String status= postSer.delSinglePost(id);
    }
    
    
}
