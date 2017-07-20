package com.linksharing.dto;

import com.linksharing.model.entities.LinkResource;

/**
 * Created by karan on 13/7/17.
 */
public class LinkResourceDTO extends ResourceDTO{

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LinkResourceDTO(){}
    public LinkResourceDTO(LinkResource linkResource){
        super(linkResource);
        this.url=linkResource.getUrl();
    }
}
