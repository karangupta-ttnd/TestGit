package com.linksharing.model.entities;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public class Subscriptions {

    Topic topic;
    User user;
    enum seriousness{_SERIOUS,_VERY_SERIOUS,_CASUAL};
    Date dateCreated;


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
