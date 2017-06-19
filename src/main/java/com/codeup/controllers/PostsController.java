package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String post(){
        return "Post Index Page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable long id) {
        return "View an individual post. ID: " + id;
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
