package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import com.codeup.svcs.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Carlos on 6/19/17.
 */
@Controller
public class PostsController {
    private final PostSvc postSvc;
    private final UserSvc userSvc;

    @Autowired
    public PostsController(PostSvc postSvc, UserSvc userSvc) {
        this.postSvc = postSvc;
        this.userSvc = userSvc;
    }

    @GetMapping("/posts")
    public String viewAll(Model model){
        Iterable<Post> all = postSvc.findAll();
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
    public String postEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

//    @PostMapping("/posts/{id}/edit")
//    public String postEdit(
//            @PathVariable long id,
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "body") String body,
//            Model model
//    ) {
//        Post post = postSvc.findOne(id);
//        post.setTitle(title);
//        post.setBody(body);
//        postSvc.save(post);
//        model.addAttribute("post", post);
//        return "posts/edit";
//    }

    @PostMapping("/posts/{id}/edit")
    public String postEdit(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

//    @GetMapping("/delete/{id}")
//    public String deletePost(@PathVariable long id) {
//        postSvc.deletePost(id);
////        postSvc.deletePost(post);
//        return"redirect;/posts";
//    }

    @PostMapping("/delete/{id}")
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.deletePost(post.getId());
        model.addAttribute("msg","Your post was deleted correctly");
        return "posts/index";
    }

}
