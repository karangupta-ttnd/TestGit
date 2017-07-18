package com.linksharing.model.services.interfaces;

import com.linksharing.dto.UserDTO;
import com.linksharing.model.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by karan on 11/7/17.
 */
public interface UserService {

   void login();
   Map<String, String> register(UserDTO user, MultipartFile file);
   void signout();
   void forgotPassword();
   void updateProfileDetails();
}
