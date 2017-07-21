package com.linksharing.model.dao.impl;

import com.linksharing.model.dao.interfaces.TopicDAO;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karan on 19/7/17.
 */
@Repository("TopicDAOImpl")
public class TopicDAOImpl implements TopicDAO {

    @Autowired
    SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(TopicDAOImpl.class);

    @Transactional
    public void addTopic(Topic topic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(topic);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            logger.info("addTopic() in TopicDAOImpl" + e);
        } finally {
            session.close();
        }
    }


    public List<Topic> getAllTopicsCurrentUser(int id) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Topic topic WHERE topic.createdBy=:id ").setInteger("id", id);
        List<Topic> topicList = query.list();
        System.out.println(">>>" + topicList);
        session.close();
        return topicList;

    }

    public Topic getTopicById(int id) {
        Topic topic = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Topic topic WHERE topic.id=:id ").setInteger("id", id);
        Object queryResult = query.uniqueResult();
        if (queryResult != null)
            topic = (Topic) queryResult;
        session.close();
        return topic;

    }


    public List<Object> getRecentPublicTopics() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Resource r WHERE r.topic.visibility=0 ORDER BY r.lastUpdated DESC").setMaxResults(5);
        List<Object> recentPublicTopicList = query.list();
        session.close();
        return recentPublicTopicList;

    }


}
