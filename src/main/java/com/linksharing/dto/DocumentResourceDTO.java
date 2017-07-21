package com.linksharing.dto;

import com.linksharing.model.entities.DocumentResource;
import com.linksharing.model.entities.Resource;

/**
 * Created by karan on 13/7/17.
 */
public class DocumentResourceDTO extends ResourceDTO {

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public DocumentResourceDTO(){}

    public DocumentResourceDTO(DocumentResource documentResource){
        super(documentResource);
        this.filePath=documentResource.getFilePath();
    }
}
