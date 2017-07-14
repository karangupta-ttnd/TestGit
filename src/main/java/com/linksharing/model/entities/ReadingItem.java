package com.linksharing.model.entities;

import javax.persistence.*;

/**
 * Created by karan on 13/7/17.
 */
@Entity
public class ReadingItem {

    @Id
    @Column(name = "reading_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(targetEntity = Resource.class,optional = false,cascade = CascadeType.ALL)
    private Resource resource;

    @ManyToOne(targetEntity = User.class,optional = false,cascade = CascadeType.ALL)
    private User user;

    @Column(nullable = false)
    private Boolean isRead;

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

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
