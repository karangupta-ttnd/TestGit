package com.linksharing.util;

import com.linksharing.model.dao.impl.UserDAOImpl;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by karan on 20/7/17.
 */
@Controller
public class DBtest {

    @Autowired
    SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(DBtest.class);


    @RequestMapping(value={"test"}, method = RequestMethod.GET)
    public String getRecentPublicTopics(Model model){
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM Resource r WHERE r.topic.visibility=0 ORDER BY r.lastUpdated DESC").setMaxResults(5);
        List<Object> topicList =query.list();
        model.addAttribute("topicList",topicList);
        session.close();

        Query query = session.createQuery(
                " FROM Topic topic " +
                " WHERE visibility=0 " +
                "ORDER BY topic.dateCreated DESC").setMaxResults(5);

        List<Object> topicList =query.list();
        model.addAttribute("topicList",topicList);
        session.close();


        return "errorsAndsuccess/test";
    }


}
