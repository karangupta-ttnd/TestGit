package com.linksharing.model.dao.interfaces;

import com.linksharing.model.entities.DocumentResource;
import com.linksharing.model.entities.LinkResource;

/**
 * Created by karan on 20/7/17.
 */
public interface ResourceDAO {

    void addLinkResource(LinkResource linkResource);
    void addDocumentResource(DocumentResource documentResource);

}
