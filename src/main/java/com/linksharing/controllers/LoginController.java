package com.linksharing.controllers;

import com.linksharing.dto.LoginDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.interfaces.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by karan on 18/7/17.
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    MessageSource messageSource;

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("userLogin") LoginDTO loginDTO, BindingResult result, HttpSession session) {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
            List<String> messages = new ArrayList<String>();
            for (Object object : result.getAllErrors()) {
                try {
                    if (object instanceof FieldError) {
                        FieldError fieldError = (FieldError) object;
                        messages.add(messageSource.getMessage(fieldError, null));
                    }
                } catch (Exception e) {
                    logger.info("Exception while checking fields" + e.getMessage());
                }
            }
            model.setViewName("errorsAndsuccess/error");
            model.addObject("message", messages);
            logger.info("Error while checking form fields" + messages.toString());
            return model;
        }
        int responseCode = userService.login(loginDTO, session);

        switch (responseCode) {
            case 1:
                model.setViewName("errorsAndsuccess/error");
                model.addObject("message", "Your Account is blocked");
                break;
            case 2:
                model.setViewName("redirect:/showDashboard");
                break;
            case 3:
                model.setViewName("errorsAndsuccess/error");
                model.addObject("message", "Username and password should be unique");
                break;
            case 4:
                model.setViewName("errorsAndsuccess/error");
                model.addObject("message", "Some Exception occured. Please try again later");
                break;
        }

        logger.info("value of model" + model);
        return model;
    }


}
