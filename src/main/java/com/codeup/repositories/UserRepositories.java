package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Carlos on 6/22/17.
 */
public interface UserRepositories extends CrudRepository<User, Long> {
}
