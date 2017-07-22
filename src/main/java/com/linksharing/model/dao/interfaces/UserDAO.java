package com.linksharing.model.dao.interfaces;

import com.linksharing.model.entities.User;

/**
 * Created by karan on 11/7/17.
 */
public interface UserDAO {

    void saveUser(User user);
    User getUserByEmailandUsername(String email, String username);
    User getRegisteredUser(String email, String password);
    User getUserById(int id);
    int saveTemporaryPassword(String email, String username,int pin);
}
