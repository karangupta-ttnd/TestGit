package com.linksharing.dto;

import com.linksharing.enums.SeriousnessType;

import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
public class SubscriptionsDTO {

    Integer id;
    private UserDTO user;
    private TopicDTO topic;
    private SeriousnessType seriousness;
    private Date dateCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
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
