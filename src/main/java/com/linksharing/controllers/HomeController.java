package com.linksharing.controllers;

import com.linksharing.dto.LoginDTO;
import com.linksharing.dto.RecentShareDTO;
import com.linksharing.dto.TopicDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.interfaces.TopicService;
import com.linksharing.util.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by karan on 15/7/17.
 */

@Controller
public class HomeController {

    @Autowired
    MailService mailService;
    @Autowired
    TopicService topicService;


    @RequestMapping(value={"/home","/"}, method = RequestMethod.GET)
    public String viewHome(Model model, HttpSession session, HttpServletRequest request){
//        mailService.sendEmail("karan.gupta@tothenew.com");
        int id = session.getAttribute("userId")!=null?(Integer)session.getAttribute("userId"):0;
        if (id != 0) {
            return "redirect: /showDashboard";
        } else {
            request.setAttribute("recentPublicTopicList",topicService.getRecentPublicTopic());
            model.addAttribute("userRegister", new UserDTO());
            model.addAttribute("userLogin",new LoginDTO());
            return "/common/home";
        }
    }

}
