package com.codeup.svcs;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Carlos on 6/22/17.
 */
@Service("userSvc")
public class UserSvc {

    private UsersRepository userDao;

    @Autowired
    public UserSvc(UsersRepository userDao) {
        this.userDao = userDao;
    }

    public User findOne(long id) {
        return userDao.findOne(id);
    }

}
