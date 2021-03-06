package com.linksharing.model.services.impl;

import com.linksharing.dto.EMailerDTO;
import com.linksharing.dto.ForgotPasswordDTO;
import com.linksharing.dto.LoginDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.dao.interfaces.UserDAO;
import com.linksharing.model.entities.User;
import com.linksharing.model.services.interfaces.UserService;
import com.linksharing.util.mail.service.MailService;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by karan on 13/7/17.
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    MailService mailService;

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);


    public Map<String, String> register(UserDTO userdto, MultipartFile file) {

        Map mp = new LinkedHashMap<String, String>();
        try {
            User user = new User(userdto);
            user.setPhoto(userdto.getMultipartFile().getBytes());
            User someUser;
            someUser = userDAO.getUserByEmailandUsername(user.getEmail(), user.getUsername());
            if (someUser == null) {
                user.setActive(true);
                userDAO.saveUser(user);
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
        } catch (Exception e) {
            logger.info("register() in UserServiceImpl()" + e);
            mp.put("errorsAndsuccess/error", e.toString());
            return mp;
        }

    }

    public int login(LoginDTO loginDTO, HttpSession session) {
        Map mp = new LinkedHashMap<String, String>();
        try {
            User user = userDAO.getRegisteredUser(loginDTO.getLoginId(), loginDTO.getLoginPass());
            if (user != null) {
                if (!user.getActive()) {
                    return 1;
                }
                session.setAttribute("userId", user.getId());
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("lastName", user.getLastName());
                session.setAttribute("userName", user.getUsername());
                session.setAttribute("userImage", Base64.encode(user.getPhoto()));
            } else {
                return 3;
            }
            return 2;
        } catch (Exception e) {
            return 4;
        }
    }

    public UserDTO getUser(int id) {
        return new UserDTO(userDAO.getUserById(id));
    }

    public void signout(HttpSession session) {
        session.invalidate();
    }

    public int forgotPassword(ForgotPasswordDTO forgotPasswordDTO) {
        try {
            Random rnd = new Random();
            rnd.setSeed(5);
            int randomNumber = 100000 + rnd.nextInt() * 900000;
            if (userDAO.saveTemporaryPassword(forgotPasswordDTO.getEmail(), forgotPasswordDTO.getUsername(), randomNumber) > 0) {
                EMailerDTO eMailerDTO = new EMailerDTO();
                eMailerDTO.setFrom("karangupta.199317@gmail.com");
                eMailerDTO.setTo(forgotPasswordDTO.getEmail());
                eMailerDTO.setSubject("Temporary password for Login");
                eMailerDTO.setBody("Use the following pin as your password: "+randomNumber);
                mailService.sendEmail(eMailerDTO);
                return 1;
            } else {
                return 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    public void updateProfileDetails() {
    }


}
