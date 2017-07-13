package com.linksharing.model.entities;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public class Topic {

    String name;
    User createdBy;
    Date dateCreated;
    Date lastUpdated;
    enum visibility{_PUBLIC,_PRIVATE};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
