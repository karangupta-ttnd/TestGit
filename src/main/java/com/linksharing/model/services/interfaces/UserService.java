package com.linksharing.model.services.interfaces;

import com.linksharing.dto.UserDTO;

/**
 * Created by karan on 11/7/17.
 */
public interface UserService {

   void login();
   String register(UserDTO user);
   void signout();
   void forgotPassword();
   void updateProfileDetails();

}
