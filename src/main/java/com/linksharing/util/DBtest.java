package com.linksharing.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by karan on 20/7/17.
 */

public class DBtest {

    @Autowired
    SessionFactory sessionFactory;
<<<<<<< Updated upstream
=======
    private static final Logger logger = Logger.getLogger(DBtest.class);


    @RequestMapping(value={"test"}, method = RequestMethod.GET)
    public String getRecentPublicTopics(Model model){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Resource r WHERE r.topic.visibility=0 ORDER BY r.lastUpdated DESC").setMaxResults(5);
        List<Object> topicList =query.list();
        model.addAttribute("topicList",topicList);
        session.close();
>>>>>>> Stashed changes



}
