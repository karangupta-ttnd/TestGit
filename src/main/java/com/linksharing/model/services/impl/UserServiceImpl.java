package com.linksharing.model.services.impl;

import com.linksharing.dto.UserDTO;
import com.linksharing.model.dao.impl.UserDAOImpl;
import com.linksharing.model.entities.User;
import com.linksharing.model.services.interfaces.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by karan on 13/7/17.
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAOImpl userDAOImpl;
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);


    public Map<String, String> register(UserDTO userdto, MultipartFile file) {
        Map mp = new LinkedHashMap<String, String>();

        try {
            User user = new User(userdto);
            user.setPhoto(userdto.getMultipartFile().getBytes());
            User someUser;
            someUser = userDAOImpl.getUserByEmailandUsername(user.getEmail(),user.getUsername());
            if (someUser == null) {
                user.setActive(true);
                userDAOImpl.saveUser(user);
                mp.put("errorsAndsuccess/success", "You have registered successfully <br> Click <a href=\"home\">here</a> to go back.");
                return mp;
            } else {
                    if (someUser.getActive()) {
                        mp.put("errorsAndsuccess/success", "User already registered Click <a href=\"home\">here</a> to go back.");
                        return mp;
                    } else {
                        mp.put("errorsAndsuccess/error", "Account Blocked");
                        return mp;
                    }
                }
        } catch ( Exception e)
        {
            logger.info("register() in UserServiceImpl()" + e);
            mp.put("errorsAndsuccess/error", e.toString());
            return mp;
        }

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
