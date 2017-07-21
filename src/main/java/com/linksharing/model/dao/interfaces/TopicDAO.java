package com.linksharing.model.dao.interfaces;

import com.linksharing.model.entities.Topic;

import java.util.List;

/**
 * Created by karan on 13/7/17.
 */
public interface TopicDAO {
    void addTopic(Topic topic);
    List<Topic> getAllTopicsCurrentUser(int id);
    Topic getTopicById(int id);
    List<Object> getRecentPublicTopics();

}
