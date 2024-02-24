package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Post;

public interface SearchRepo {
	
	List<Post> findByText(String text);

}
