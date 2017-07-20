package com.linksharing.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.linksharing.dto.*;
import com.linksharing.model.entities.LinkResource;
import com.linksharing.model.entities.Resource;
import com.linksharing.model.services.interfaces.ResourceService;
import com.linksharing.model.services.interfaces.TopicService;
import com.linksharing.model.services.interfaces.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by karan on 20/7/17.
 */
@Controller
public class ResourceController {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    ResourceService resourceService;


    @RequestMapping(value = "/add_resource_link", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String add_resource_link(@RequestBody String json ,HttpSession session) {
        int id = session.getAttribute("userId") != null ? (Integer) session.getAttribute("userId") : 0;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonResult = mapper.createObjectNode();
        if (id != 0) {
            try {
                LinkResourceDTO linkResourceDTO = mapper.readValue(json, LinkResourceDTO.class);
                UserDTO userDTO = userService.getUser(id);
                int responseCode = resourceService.addLinkResource(linkResourceDTO, userDTO);
                switch (responseCode) {
                    case 1:
                        jsonResult.put("responseCode", 1);
                        jsonResult.put("reponseStatus", "success");
                        jsonResult.put("responseMessage", "Topic URL added successfully");
                        break;
                    case 2:
                        jsonResult.put("responseCode", 2);
                        jsonResult.put("reponseStatus", "fail");
                        jsonResult.put("responseMessage", "Error while adding topic related url");
                        break;
                }
                return mapper.writeValueAsString(jsonResult);
            } catch (Exception e) {
                System.out.print("Exception in add_resource_link() in ResourceController: " + e);
                return "Exception caught in add_resource_link() ResourceController";
            }
        } else {
            try {
                jsonResult.put("responseCode", 3);
                jsonResult.put("reponseStatus", "invalid");
                jsonResult.put("responseMessage", "You need to login first");
                return mapper.writeValueAsString(jsonResult);
            } catch (Exception e) {
                System.out.print(e);
                return "Exception in add_resource_link() though user not logged in";
            }
        }

    }

    @RequestMapping(value = "/save_resource_document", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String save_resource_document(@RequestParam("resourceFile") MultipartFile file,@RequestParam("resourceTopic") int topicId,@RequestParam("document_Description")String description , HttpSession session, MultipartHttpServletRequest request) {
        int id = session.getAttribute("userId") != null ? (Integer) session.getAttribute("userId") : 0;
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonResult = mapper.createObjectNode();
        if (id != 0) {
            try {
                UserDTO userDTO = userService.getUser(id);
                int responseCode = resourceService.addDocumentResource(file,topicId,description,userDTO);
                switch (responseCode) {
                    case 1:
                        jsonResult.put("responseCode", 1);
                        jsonResult.put("reponseStatus", "success");
                        jsonResult.put("responseMessage", "Resource document added successfully");
                        break;
                    case 2:
                        jsonResult.put("responseCode", 2);
                        jsonResult.put("reponseStatus", "fail");
                        jsonResult.put("responseMessage", "Error while adding topic related document resource");
                        break;
                }
                return mapper.writeValueAsString(jsonResult);
            } catch (Exception e) {
                System.out.print("Exception in save_resource_document() in ResourceController: " + e);
                return "Exception caught in save_resource_document() ResourceController";
            }
        } else {
            try {
                jsonResult.put("responseCode", 3);
                jsonResult.put("reponseStatus", "invalid");
                jsonResult.put("responseMessage", "You need to login first");
                return mapper.writeValueAsString(jsonResult);
            } catch (Exception e) {
                System.out.print(e);
                return "Exception in save_resource_document() though user not logged in";
            }
        }
    }



}
