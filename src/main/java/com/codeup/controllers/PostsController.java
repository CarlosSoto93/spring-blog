package com.codeup.controllers;

import com.codeup.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    public String post(Model model){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Post One", "First post in the index page"));
        posts.add(new Post("Post Two", "Second post in the index page"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = new Post();
        post.setTitle("Single Post");
        post.setBody("This post is for the individual post page");
        model.addAttribute("post", post);
        model.addAttribute("id",id);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreateForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate() {
        return "create a new post";
    }





}
