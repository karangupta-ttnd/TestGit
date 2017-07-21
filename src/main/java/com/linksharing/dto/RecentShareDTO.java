package com.linksharing.dto;

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


    public RecentShareDTO(Object object){
        topicId=((Topic)object).getId();
        topicName=((Topic)object).getName();
        userId=((Topic)object).getCreatedBy().getId();
        firstName =((Topic)object).getCreatedBy().getFirstName();
        lastName=((Topic)object).getCreatedBy().getLastName();
        username=((Topic)object).getCreatedBy().getUsername();
        photo= Base64.encode(((Topic)object).getCreatedBy() .getPhoto());
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

    public String getTopicName() {
        return topicName;
    }

    public String getPhoto() {
        return photo;
    }
}
