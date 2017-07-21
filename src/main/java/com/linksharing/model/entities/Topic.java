package com.linksharing.model.entities;

import com.linksharing.dto.TopicDTO;
import com.linksharing.enums.Visibility;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */

@Entity
public class Topic {

    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @ManyToOne(targetEntity = User.class, optional = false)
    private User createdBy;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date lastUpdated;

    @Column(nullable = false)
    private Visibility visibility;

    public Topic() {
    }

    public Topic(TopicDTO topicDTO) {
        if (topicDTO != null) {
            this.createdBy = topicDTO.getCreatedBy();
            this.dateCreated = topicDTO.getDateCreated();
            this.id = topicDTO.getId();
            this.lastUpdated = topicDTO.getLastUpdated();
            this.name = topicDTO.getName();
            this.visibility = topicDTO.getVisibility();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", visibility=" + visibility +
                '}';
    }
}
