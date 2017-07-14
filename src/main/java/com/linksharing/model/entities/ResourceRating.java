package com.linksharing.model.entities;

import javax.persistence.*;

/**
 * Created by karan on 13/7/17.
 */

@Entity
public class ResourceRating {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(targetEntity = Resource.class,optional=false,cascade = CascadeType.ALL)
    Resource resource;

    @ManyToOne(targetEntity = User.class,optional = false,cascade = CascadeType.ALL)
    User user;

    @Column(nullable = false)
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
