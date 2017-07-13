package com.linksharing.model.entities;

/**
 * Created by karan on 13/7/17.
 */
public class ResourceRating {

    Resource resource;
    User user;
    Integer score;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
