package com.linksharing.controllers;

import com.linksharing.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by karan on 15/7/17.
 */

@Controller
public class CommonController {

    @RequestMapping(value={"/home","/"}, method = RequestMethod.GET)
    public ModelAndView viewHome(){
        System.out.println("in viewHome");
        return new ModelAndView("/common/home","user",new UserDTO());
    }

}
