package com.linksharing.dto;

import com.linksharing.enums.Visibility;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */

public class TopicDTO {

    private Integer id;
    private String name;
    private User createdBy;
    private Date dateCreated;
    private Date lastUpdated;
    private Visibility visibility;

    public TopicDTO() {
    }

    public TopicDTO(Topic topic) {
        this.id = topic.getId();
        this.createdBy = topic.getCreatedBy();
        this.dateCreated = topic.getDateCreated();
        this.lastUpdated = topic.getLastUpdated();
        this.name = topic.getName();
        this.visibility = topic.getVisibility();

    }


    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
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
