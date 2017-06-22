package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class PostsController {
    private final PostSvc postSvc;

    @Autowired
    public PostsController(PostSvc postSvc) {
        this.postSvc = postSvc;
    }
//    private final PostsRepositories postDao;
//
//    @Autowired
//    public PostsController(PostsRepositories postDao){
//        this.postDao = postDao;
//    }


    @GetMapping("/posts")
    public String post(Model model){
        List<Post> all = postSvc.findAll();
        model.addAttribute("posts", all);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post",post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreateForm(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body,
            Model model
    ) {
        Post post = new Post(title, body);
        postSvc.save(post);
        model.addAttribute("post", post);
        return "posts/create";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }



}
