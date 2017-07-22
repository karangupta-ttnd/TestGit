package com.linksharing.controllers;

import com.linksharing.model.services.interfaces.TopicService;
import com.linksharing.model.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by karan on 22/7/17.
 */
@Controller
public class PostController {

    @Autowired
    UserService userService;

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/showPost/id={id}", method = RequestMethod.GET)
    public ModelAndView showPost(ModelAndView modelAndView, @PathVariable String id) {
        modelAndView.setViewName("profile/showPosts");
        return modelAndView;
    }


}
