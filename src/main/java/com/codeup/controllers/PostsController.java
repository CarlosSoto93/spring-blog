package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.svcs.PostSvc;
import com.codeup.svcs.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
        User user = userSvc.findOne(post.getUser().getId());
        model.addAttribute("post",post);
        model.addAttribute("user",user);
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
            @Valid Post Post,
            Errors validation,
            Model model
    ) {
        if (Post.getTitle().endsWith("?")) {
            validation.rejectValue(
                    "title",
                    "post.title",
                    "You can't be unsure about your title!"
            );
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("post", Post);
            return "posts/create";
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post.setUser(user);
        postSvc.save(Post);
        model.addAttribute("post", Post);
        return "redirect:/posts/" + Post.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String postEditForm(@PathVariable long id, Model model) {
        Post post = postSvc.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String postEdit(@ModelAttribute Post post) {
        postSvc.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@ModelAttribute Post post, Model model) {
        postSvc.deletePost(post.getId());
//        model.addAttribute("msg","Your post was deleted correctly");
        return "redirect:/posts";
    }

}
