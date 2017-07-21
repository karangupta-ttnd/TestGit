package com.linksharing.model.dao.impl;


import com.linksharing.model.dao.interfaces.UserDAO;
import com.linksharing.model.entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karan on 11/7/17.
 */

@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);


    @Transactional
    public void saveUser(User user) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    public User getUserByEmailandUsername(String email, String username) {
        User user = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where email =:email and username=:uname").setString("email", email).setString("uname", username);
        Object queryResult = query.uniqueResult();
        if (queryResult != null)
            user = (User) queryResult;
        session.close();
        return user;
    }

    public User getRegisteredUser(String email, String password) {
        User user = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where email =:email or username=:uname and password=:pass and active=1").setString("email", email).setString("uname", email).setString("pass", password);
        Object queryResult = query.uniqueResult();
        if (queryResult != null)
            user = (User) queryResult;
        session.close();
        return user;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        session.close();
        return user;

    }


}
