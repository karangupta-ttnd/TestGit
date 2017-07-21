package com.linksharing.model.dao.impl;

import com.linksharing.model.dao.interfaces.ResourceDAO;
import com.linksharing.model.entities.DocumentResource;
import com.linksharing.model.entities.LinkResource;
import com.linksharing.model.entities.Resource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karan on 20/7/17.
 */
@Repository("ResourceDAOImpl")
public class ResourceDAOImpl implements ResourceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addLinkResource(LinkResource linkResource){

            Session session = sessionFactory.openSession();
            session.beginTransaction();
        try {
            session.save(linkResource);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println("addTopicURL() in TopicDAOImpl" + e);
            session.getTransaction().rollback();
            session.close();
        }
    }


    @Transactional
    public void addDocumentResource(DocumentResource documentResource){

            Session session = sessionFactory.openSession();
            session.beginTransaction();
        try {
            session.save(documentResource);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("addDocumentResource() in ResourceDAOImpl" + e);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

}
