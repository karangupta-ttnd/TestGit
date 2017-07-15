package com.linksharing.controllers;


import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.impl.UserServiceImpl;
import com.linksharing.model.services.interfaces.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


/**
 * Created by karan on 11/7/17.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user")UserDTO user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        logger.info(user.toString());
        userService.register(user);
        return
    }

}



