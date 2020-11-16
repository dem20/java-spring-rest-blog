package com.pluralsight.blog.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.pluralsight.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	//Before RestResource
	//http://localhost:8080/posts/search/findByTitleContaining?title=Smart
	//After
	//http://localhost:8080/posts/search/containsTitle?title=Smart
	@RestResource(rel="contains-title", path="containsTitle")
	public List<Post> findByTitleContaining(String title);
}