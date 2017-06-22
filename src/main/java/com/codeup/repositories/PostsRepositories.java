package com.codeup.repositories;


import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Carlos on 6/21/17.
 */
public interface PostsRepositories extends CrudRepository<Post, Long> {

}
