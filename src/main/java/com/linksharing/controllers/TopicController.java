package com.linksharing.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.linksharing.dto.TopicDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.services.interfaces.TopicService;
import com.linksharing.model.services.interfaces.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by karan on 19/7/17.
 */
@Controller
public class TopicController {

    @Autowired
    UserService userService;

    @Autowired
    TopicService topicService;

    private static final Logger logger = Logger.getLogger(TopicController.class);


    @RequestMapping(value = "/add_new_topic", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String add_new_topic(@RequestBody String json, HttpSession session) {
        int id = session.getAttribute("userId") != null ? (Integer) session.getAttribute("userId") : 0;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonResult = mapper.createObjectNode();
        if (id != 0) {
            try {
                TopicDTO topicDTO = mapper.readValue(json, TopicDTO.class);
                UserDTO userDTO = userService.getUser(id);
                int responseCode = topicService.addTopic(topicDTO, userDTO);
                switch (responseCode) {
                    case 1:
                        jsonResult.put("responseCode",1);
                        jsonResult.put("reponseStatus","success");
                        jsonResult.put("responseMessage","Topic added successfully");
                        break;
                    case 2:
                        jsonResult.put("responseCode",2);
                        jsonResult.put("reponseStatus","fail");
                        jsonResult.put("responseMessage","Error while adding topic");
                        break;
                }
                logger.info(">>>>" + topicDTO);
                return mapper.writeValueAsString(jsonResult) ;
            } catch (Exception e) {
                System.out.print("Exception in add_new_topic() in TopicController" + e);
                return "Exception caught in add_new_topic() Topic Controller";
            }
        } else {
            try {
                jsonResult.put("responseCode",3);
                jsonResult.put("reponseStatus","invalid");
                jsonResult.put("responseMessage","You need to login first");
                return mapper.writeValueAsString(jsonResult);
            } catch (Exception e) {
                System.out.print(e);
                return "Exception in add_new_topic() though user not logged in";
            }
        }

    }

    @RequestMapping(value = "/validate_topic_name", method = RequestMethod.POST)
    @ResponseBody
    public Boolean validate_topic_name(@RequestBody String string) {

        System.out.println(">>>>" + string);

//        if(topicService.isTopicUnique())
//            return true;
        return false;
    }




}
