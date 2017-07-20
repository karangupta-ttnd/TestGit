package com.linksharing.model.entities;

import com.linksharing.dto.LinkResourceDTO;
import org.hibernate.annotations.ColumnDefault;

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

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public LinkResource(){}
    public LinkResource(LinkResourceDTO linkResourceDTO){
        super(linkResourceDTO);
        this.url=linkResourceDTO.getUrl();
    }



}
