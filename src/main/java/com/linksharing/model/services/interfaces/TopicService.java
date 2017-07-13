package com.linksharing.model.services.interfaces;

/**
 * Created by karan on 13/7/17.
 */
public interface TopicService {

    void changeVisibility();
    void sendInvitation();
    void updateTopicDetails();
    void deleteTopic();
    void getAllTopics();
    void searchTopics();
    void viewPost();
    void getAllTopicsCount();

}
