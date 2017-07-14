package com.linksharing.dto;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public class ResourceDTO {

    String description;
    UserDTO createdBy;
    TopicDTO topicDTO;
    Date dateCreated;
    Date lastUpdated;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public TopicDTO getTopicDTO() {
        return topicDTO;
    }

    public void setTopicDTO(TopicDTO topicDTO) {
        this.topicDTO = topicDTO;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
