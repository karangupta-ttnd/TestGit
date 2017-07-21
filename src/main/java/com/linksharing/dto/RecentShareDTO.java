package com.linksharing.dto;

import com.linksharing.model.entities.DocumentResource;
import com.linksharing.model.entities.Resource;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Created by karan on 21/7/17.
 */
public class RecentShareDTO {

  private int topicId;
  private int userId;
  private String firstName;
  private String lastName;
  private String username;
  private String topicName;
  private String photo;
  private String description;


    public RecentShareDTO(Object object){
        topicId=((Resource)object).getTopic().getId();
        topicName=((Resource)object).getTopic().getName();
        userId=((Resource)object).getTopic().getCreatedBy().getId();
        firstName =((Resource)object).getTopic().getCreatedBy().getFirstName();
        lastName=((Resource)object).getTopic().getCreatedBy().getLastName();
        username=((Resource)object).getTopic().getCreatedBy().getUsername();
        photo= Base64.encode(((Resource)object).getTopic().getCreatedBy() .getPhoto());
        description=((Resource)object).getDescription();
    }

    public int getTopicId() {
        return topicId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getPhoto() {
        return photo;
    }
}
