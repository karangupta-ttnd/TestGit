package com.linksharing.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.interfaces.TopicService;
import com.linksharing.model.services.interfaces.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


/**
 * Created by karan on 11/7/17.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TopicService topicService;

    MessageSource messageSource;
    private static final Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") UserDTO user, BindingResult result, @RequestParam("multipartFile") MultipartFile file) {
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
        logger.info(user);
        Map<String, String> map = userService.register(user, file);
        Map.Entry<String, String> entry = map.entrySet().iterator().next();
        String key = entry.getKey();
        String value = entry.getValue();
        logger.debug("value of key(ViewName) in UserController" + key + "value of value(message) in UserController" + value);
        model.setViewName(key);
        model.addObject("message", value);
        logger.info("value of model" + model);
        return model;
    }

    @RequestMapping(value = "/showDashboard", method = RequestMethod.GET)
    public ModelAndView showDashboard(ModelAndView modelAndView, HttpSession session) {
        int id = session.getAttribute("userId") != null ? (Integer) session.getAttribute("userId") : 0;
        if (id != 0) {
            try {
                System.out.println("in dashboard method");
                modelAndView.setViewName("profile/dashboard");
                modelAndView.addObject("topicList",topicService.getAllTopics(id));
            } catch (Exception e) {
                System.out.print("Exception in showDashboard() in UserController"+e);
            }
        } else {
            modelAndView.addObject("message", "Please login through form");
            modelAndView.setViewName("redirect: /home");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/showProfile/id={id}", method = RequestMethod.GET)
    public ModelAndView showProfile(ModelAndView modelAndView, HttpSession session,@PathVariable String id) {
        int userId = session.getAttribute("userId") != null ? (Integer) session.getAttribute("userId") : 0;
        if (userId != 0) {
            topicService.getAllTopics(userId);
            modelAndView.setViewName("profile/privateProfile");
        }else{
            userService.getUser(Integer.parseInt(id));
            modelAndView.setViewName("profile/publicProfile");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        userService.signout(session);
        modelAndView.setViewName("redirect:/home");
        modelAndView.addObject("message", "You have logged out successfully");
        return modelAndView;
    }


}



