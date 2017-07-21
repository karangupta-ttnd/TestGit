package com.linksharing.dto;

import com.linksharing.enums.SeriousnessType;
import com.linksharing.model.entities.Subscriptions;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public class SubscriptionsDTO {

    private Integer id;
    private User user;
    private Topic topic;
    private SeriousnessType seriousness;
    private Date dateCreated;

    public SubscriptionsDTO(){}

    public SubscriptionsDTO(Subscriptions subscriptions){
        if (subscriptions!=null) {
            this.id = subscriptions.getId();
            this.user = subscriptions.getUser();
            this.topic = subscriptions.getTopic();
            this.seriousness = subscriptions.getSeriousness();
            this.dateCreated = subscriptions.getDateCreated();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public SeriousnessType getSeriousness() {
        return seriousness;
    }

    public void setSeriousness(SeriousnessType seriousness) {
        this.seriousness = seriousness;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
