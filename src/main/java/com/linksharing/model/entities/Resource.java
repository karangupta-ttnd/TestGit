package com.linksharing.model.entities;

import com.linksharing.dto.ResourceDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by karan on 13/7/17.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Resource {

    @Id
    @Column(name = "resource_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 1000)
    private String description;

    @ManyToOne(targetEntity = User.class,optional = false)
    @JoinColumn(name = "user_id")
    private User createdBy;

    @ManyToOne(targetEntity = Topic.class,cascade = CascadeType.ALL,optional = false)
    private Topic topic;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    private Date lastUpdated;

    public Resource(){}

   public Resource(ResourceDTO resourceDTO){
        if(resourceDTO!=null) {
            this.createdBy = resourceDTO.getCreatedBy();
            this.dateCreated = resourceDTO.getDateCreated();
            this.description = resourceDTO.getDescription();
            this.id = resourceDTO.getId();
            this.lastUpdated = resourceDTO.getLastUpdated();
            this.topic = resourceDTO.getTopic();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
