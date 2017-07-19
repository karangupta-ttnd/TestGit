package com.linksharing.model.services.interfaces;

import com.linksharing.dto.LoginDTO;
import com.linksharing.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by karan on 11/7/17.
 */
public interface UserService {

   int login(LoginDTO user, HttpSession session);
   Map<String, String> register(UserDTO user, MultipartFile file);
   void signout(HttpSession session);
   void forgotPassword();
   void updateProfileDetails();

}
