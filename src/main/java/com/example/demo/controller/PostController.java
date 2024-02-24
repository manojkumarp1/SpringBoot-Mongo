package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SearchRepo;

@RestController
public class PostController 
{
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepo srepo;
	@GetMapping("/")
	public RedirectView redirectToPage() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/swagger-ui/index.html");
        return redirectView;
    }
	@GetMapping("/posts")
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post p)
	{
		
		repo.save(p);
		return p;
		
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> Search(@PathVariable String text)
	{
		return srepo.findByText(text);
	}
	
	
	
	
	
	

}
