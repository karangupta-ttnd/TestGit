package com.linksharing.model.services.interfaces;

import com.linksharing.dto.TopicDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.model.entities.Topic;

import java.util.List;

/**
 * Created by karan on 13/7/17.
 */
public interface TopicService {

    void changeVisibility();
    void sendInvitation();
    void updateTopicDetails();
    void deleteTopic();
    List<Topic> getAllTopics(int id);
    void searchTopics();
    void viewPost();
    void getAllTopicsCount();
    boolean isTopicUnique(TopicDTO topicDTO);
    int addTopic(TopicDTO topicDTO, UserDTO userDTO);
    TopicDTO getTopicDTO(int id);
    Topic getTopic(int id);
    TopicDTO getRecentPublicTopic();
}
