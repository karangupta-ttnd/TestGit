package com.linksharing.controllers;


import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.impl.UserServiceImpl;
import com.linksharing.model.services.interfaces.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by karan on 11/7/17.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public String testHome(){
//        System.out.println("in controller" );
//        return "index";
//    }

    @ResponseBody
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView viewHome(){
        System.out.println("home method invoked" );
        ModelAndView mv =new ModelAndView("home");
        return mv;
    }


}



