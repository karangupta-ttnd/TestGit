package com.linksharing.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by karan on 11/7/17.
 */

@Controller
public class UserController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String viewHome(){
        System.out.println("in controller" );
        return "index";
    }



}



