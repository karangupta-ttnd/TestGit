package com.linksharing.model.services.impl;

import com.linksharing.dto.UserDTO;
import com.linksharing.model.dao.impl.UserDAOImpl;
import com.linksharing.model.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karan on 13/7/17.
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDAOImpl;


    public void register(UserDTO user) {
        userDAOImpl.saveUser(user);
    }


    public void login() {
    }

    public void signout() {
    }

    public void forgotPassword() {
    }

    public void updateProfileDetails() {
    }

}
