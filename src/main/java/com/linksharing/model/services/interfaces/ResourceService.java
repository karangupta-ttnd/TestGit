package com.linksharing.model.services.interfaces;

import com.linksharing.dto.DocumentResourceDTO;
import com.linksharing.dto.LinkResourceDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.entities.DocumentResource;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;

/**
 * Created by karan on 20/7/17.
 */
public interface ResourceService {
    int addLinkResource(LinkResourceDTO linkResourceDTO, UserDTO userDTO);
    int addDocumentResource(MultipartFile multipartFile,int topicId,String description, UserDTO userDTO);
}
