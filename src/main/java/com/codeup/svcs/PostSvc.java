package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Carlos on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {

    private PostsRepositories postsDao;

    @Autowired
    public PostSvc(PostsRepositories postsDao) {
        this.postsDao = postsDao;
    }

    public Iterable<Post> findAll() {
        return postsDao.findAll();
    }

    public void save(Post post) {
        postsDao.save(post);
    }

    public Post findOne(long id) {
        return postsDao.findOne(id);
    }

    public void deletePost(long id) {
        postsDao.delete(id);
    }

}
