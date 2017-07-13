package com.linksharing.model.entities;

/**
 * Created by karan on 13/7/17.
 */
public class ReadingItem {

    Resource resource;
    User user;
    Boolean isread;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getIsread() {
        return isread;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }
}
