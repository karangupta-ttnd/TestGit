package com.linksharing.controllers;

import com.linksharing.dto.UserDTO;
import com.linksharing.model.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by karan on 15/7/17.
 */

@Controller
public class HomeController {

    @RequestMapping(value={"/home","/"}, method = RequestMethod.GET)
    public String viewHome(Model model){
        System.out.println("in viewHome");
        model.addAttribute("user", new UserDTO());
        model.addAttribute("userLogin",new UserDTO());
        return "/common/home";
    }

}
