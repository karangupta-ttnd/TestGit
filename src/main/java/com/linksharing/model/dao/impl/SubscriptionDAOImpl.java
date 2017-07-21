package com.linksharing.model.dao.impl;


import com.linksharing.model.dao.interfaces.SubscriptionDAO;
import com.linksharing.model.entities.Subscriptions;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by karan on 21/7/17.
 */
@Repository("SubscriptionDAOImpl")
public class SubscriptionDAOImpl implements SubscriptionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void subscribeTopic(Subscriptions subscriptions){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(subscriptions);
        session.getTransaction().commit();
        session.close();
    }

}
