package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc() {
        createAds();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)id - 1);
    }

    private void createAds() {
        posts = new ArrayList<>();
        save(new Post("Post One from Svcs", "First post in the index page"));
        save(new Post("Post Two from Svcs", "Second post in the index page"));
    }
}
