package com.linksharing.model.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by karan on 13/7/17.
 */
@Entity
public class Subscriptions {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(targetEntity =User.class,optional = false )
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = Topic.class,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(nullable = false)
    private SeriousnessType seriousness;

    @Column(nullable = false)
    private Date dateCreated;

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
