package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {

    private PostsRepositories postsDao;

//    private List<Post> posts;

    @Autowired
    public PostSvc(PostsRepositories postsDao) {
        this.postsDao = postsDao;
        createPosts();
    }

    public PostsRepositories findAll() {
        return postsDao;
    }

    public Post save(Post post) {
        //post.setId((long)postsDao.size() + 1);
        //postsDao.add(post);
        postsDao.save(post);
        return post;
    }

    public Post findOne(long id) {
//        return postsDao.get((int)id - 1);
        return postsDao.findOne(id);
    }

    private void createPosts() {
        postsDao = new ArrayList<>();
        save(new Post("Post One from Svcs", "First post in the index page"));
        save(new Post("Post Two from Svcs", "Second post in the index page"));
    }
}
