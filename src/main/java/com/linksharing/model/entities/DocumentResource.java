package com.linksharing.model.entities;

import com.linksharing.dto.DocumentResourceDTO;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by karan on 13/7/17.
 */
@Entity
@DiscriminatorValue("Document_link")
public class DocumentResource extends Resource{

    String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public DocumentResource(){}
    public DocumentResource(DocumentResourceDTO documentResourceDTO){
        super(documentResourceDTO);
        this.filePath=documentResourceDTO.getFilePath();
    }

}
