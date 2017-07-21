package com.linksharing.model.services.impl;

import com.linksharing.dto.DocumentResourceDTO;
import com.linksharing.dto.LinkResourceDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.dao.interfaces.ResourceDAO;
import com.linksharing.model.entities.DocumentResource;
import com.linksharing.model.entities.LinkResource;
import com.linksharing.model.entities.User;
import com.linksharing.model.services.interfaces.ResourceService;
import com.linksharing.model.services.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by karan on 20/7/17.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;

    @Autowired
    private TopicService topicService;

    public int addLinkResource(LinkResourceDTO linkresourceDTO, UserDTO userDTO) {

        try {
            User user = new User(userDTO);
            linkresourceDTO.setTopic(topicService.getTopic(linkresourceDTO.getTopicId()));
            linkresourceDTO.setCreatedBy(user);
            linkresourceDTO.setDateCreated(new Date());
            linkresourceDTO.setLastUpdated(new Date());
            LinkResource linkResource = new LinkResource(linkresourceDTO);
            resourceDAO.addLinkResource(linkResource);
            return 1;
        } catch (Exception e) {
            System.out.print("Exception" + e);
            return 2;
        }

    }

    public int addDocumentResource(MultipartFile multipartFile, int topicId, String description, UserDTO userDTO) {

        if (!multipartFile.isEmpty()) {
            try {
                byte[] bytes = multipartFile.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath() + File.separator + getUniqueFileName(multipartFile.getOriginalFilename()));
                BufferedOutputStream stream = new BufferedOutputStream( new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                User user = new User(userDTO);
                DocumentResourceDTO documentResourceDTO=new DocumentResourceDTO();
                documentResourceDTO.setTopic(topicService.getTopic(topicId));
                documentResourceDTO.setCreatedBy(user);
                documentResourceDTO.setDateCreated(new Date());
                documentResourceDTO.setLastUpdated(new Date());
                documentResourceDTO.setDescription(description);
                documentResourceDTO.setFilePath(serverFile.getAbsolutePath());
//                System.out.println(">>>>>>" + documentResourceDTO.toString());
                DocumentResource documentResource=new DocumentResource(documentResourceDTO);
                resourceDAO.addDocumentResource(documentResource);

                return 1;
            } catch (Exception e) {
                System.out.println(e);
                return 2;
            }
        }else{
            return 2;
        }

    }

    public void downloadResource() {

    }

    public void downloadResource() {

    }

    private String getUniqueFileName(String fileName){
        int i=fileName.lastIndexOf('.');
        if(i==-1) {
            fileName = fileName + "_" + (int)(Math.random() * 1000);
        } else {
            fileName = fileName.substring(0, i) + "_" + (int)(Math.random() * 1000) + fileName.substring(i);
        }
        return fileName;
    }
}
