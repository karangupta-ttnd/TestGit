package com.linksharing.controllers;


import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.interfaces.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * Created by karan on 11/7/17.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;
    MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user")UserDTO user, BindingResult result, @RequestParam("multipartFile") MultipartFile file, HttpServletResponse response) {
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
                    logger.info("Exception while checking fields"+e.getMessage());
                }
            }
            model.setViewName("errorsAndsuccess/error");
            model.addObject("message", messages);
            logger.info("Error while checking form fields" + messages.toString());
            return model;
        }
        logger.info(user);
        Map<String, String> map = userService.register(user,file);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        String key = entry.getKey();
        String value = entry.getValue();
        logger.debug("value of key(ViewName) in UserController"+key+"value of value(message) in UserController"+value);
        model.setViewName(key);
        model.addObject("message", value);
        logger.info("value of model"+model);
        return model;
    }

}



