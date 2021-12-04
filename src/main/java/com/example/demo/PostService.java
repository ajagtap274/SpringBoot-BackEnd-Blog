package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class PostService {
	
	@Autowired
	private PostJPA postJPA;
	
	
	 @Transactional
	    public List<PostDto> showAllPosts() {
	        List<Post> posts = postJPA.findAll();
	        List<PostDto> pd=new ArrayList();
	        for(int i=0;i<posts.size();i++)
	        {
	        	PostDto p=mapFromPostToDto(posts.get(i));
	        	pd.add(p);
	        }
	        return pd;
	    }

	    @Transactional
	    public void createPost(PostDto postDto) {
	        Post post = mapFromDtoToPost(postDto);
	        postJPA.save(post);
	    }

	    @Transactional
	    public PostDto readSinglePost(Long id) throws ClassNotFoundException {
	    	incViewPost(id);
	        Post post = postJPA.findById(id).orElseThrow(() -> new ClassNotFoundException("For id " + id));
	        
	        return mapFromPostToDto(post);
	    }
	    
	 
	    
	    private PostDto mapFromPostToDto(Post post) {
	        PostDto postDto = new PostDto();
	        postDto.setId(post.getId());
	        postDto.setStats(post.getStats());
	        postDto.setImgURL(post.getImgURL());
	        postDto.setTitle(post.getTitle());
	        postDto.setPunchLine(post.getPunchLine());
	        postDto.setContent(post.getContent());
	        postDto.setCategory(post.getCategory());
	        return postDto;
	    }

	    private Post mapFromDtoToPost(PostDto postDto) {
	        Post post = new Post();
	       // post.setId(postDto.getId());
	        post.setStats(postDto.getStats());
	        post.setImgURL(postDto.getImgURL());
	        post.setTitle(postDto.getTitle());
	        post.setPunchLine(postDto.getPunchLine());
	        post.setContent(postDto.getContent());
	        post.setCategory(postDto.getCategory());
	        return post;
	    }
	    boolean flag=false;
	   public void incViewPost(Long id) throws ClassNotFoundException
	    {
		   if(flag==false)
		   {
			   flag=true;
		   }
		   else if(flag==true)
		   {
			   flag=false;
		   }
		   if(flag==true)
		   {
		     Post post = postJPA.findById(id).orElseThrow(() -> new ClassNotFoundException("For id " + id));
//		     int stat=post.getStats();
//		     stat++;
//		     System.out.println("***********"+stat+"  ***********");
//		     post.setStats(stat);
		     System.out.println("To increase stats");
		     Post p = new Post();
		     p.setId(post.getId());
		     p.setImgURL(post.getImgURL());
		     p.setTitle(post.getTitle());
		     p.setCategory(post.getCategory());
		     p.setContent(post.getContent());
		     p.setPunchLine(post.getPunchLine());
		     p.setStats(post.getStats()+1);
		     postJPA.save(p);
		   }
	    }
	   
	   	public String delSinglePost(Long id)
	   	{
	   		postJPA.deleteById(id);
	   		return "Successfully Deleted";
	   	}
	   
	   
	   
	   
	   
}
