package com.techtalentsouth.TechTalentBlog.BlogPost;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	@Autowired
	private BlogPostRepository  blogPostRepository;
	  private static List<BlogPost> posts = new ArrayList<>();
	
	@GetMapping(value="/blog_posts/new")
	public String newBlog(BlogPost blogpost) {
		return "blogpost/new";
	}

	@GetMapping(value="/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}
	private BlogPost blogPost;
	@PostMapping(value = "/blog_posts")
	public String create(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
	        posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
	    model.addAttribute("blogEntry", blogPost.getBlogEntry());
	        return "blogpost/result";
	}}



