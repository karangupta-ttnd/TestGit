package com.linksharing.dto;

import com.linksharing.model.entities.Resource;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public abstract class ResourceDTO {

    private int id;
    private String description;
    private User createdBy;
    private Topic topic;
    private Date dateCreated;
    private Date lastUpdated;
    private int topicId;

    public ResourceDTO(){}

    public ResourceDTO(Resource resource){
        if(resource!=null){
            this.createdBy=resource.getCreatedBy();
            this.dateCreated=resource.getDateCreated();
            this.description=resource.getDescription();
            this.id=resource.getId();
            this.lastUpdated=resource.getLastUpdated();
            this.topic=resource.getTopic();
        }
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
