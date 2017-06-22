package com.codeup.svcs;

import com.codeup.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Carlos on 6/22/17.
 */
@Service("userSvc")
public class UserSvc {

    private UserRepositories userDao;

    @Autowired
    public UserSvc(UserRepositories userDao) {
        this.userDao = userDao;
    }

}
