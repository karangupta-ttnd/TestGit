package com.linksharing.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by karan on 13/7/17.
 */
@Entity
@DiscriminatorValue("resource_link")
public class LinkResource extends Resource {
    @Column(nullable = false)
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
