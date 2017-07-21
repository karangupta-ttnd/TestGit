package com.linksharing.model.services.impl;

import com.linksharing.dto.RecentShareDTO;
import com.linksharing.dto.SubscriptionsDTO;
import com.linksharing.dto.TopicDTO;
import com.linksharing.dto.UserDTO;
import com.linksharing.enums.SeriousnessType;
import com.linksharing.model.dao.interfaces.SubscriptionDAO;
import com.linksharing.model.dao.interfaces.TopicDAO;
import com.linksharing.model.entities.Topic;
import com.linksharing.model.entities.User;
import com.linksharing.model.services.interfaces.SubscriptionService;
import com.linksharing.model.services.interfaces.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by karan on 19/7/17.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private SubscriptionService subscriptionService;

    public boolean isTopicUnique(TopicDTO topicDTO) {
//      topicDAO.checkUniqueTopic();
        return false;
    }

    public List<RecentShareDTO> getRecentPublicTopic() {
        List<Object> dataList = new ArrayList<Object>(topicDAO.getRecentPublicTopics());
        List<RecentShareDTO> recentPublicTopicList = new ArrayList<RecentShareDTO>();
        for (Object o : dataList) {
            try {
                recentPublicTopicList.add(new RecentShareDTO(o));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return recentPublicTopicList;
    }

    public int addTopic(TopicDTO topicDTO, UserDTO userDTO) {
        try {
            User user = new User(userDTO);
            topicDTO.setCreatedBy(user);
            topicDTO.setDateCreated(new Date());
            topicDTO.setLastUpdated(new Date());
            Topic topic = new Topic(topicDTO);
            SubscriptionsDTO subscriptionsDTO = new SubscriptionsDTO();
            subscriptionsDTO.setDateCreated(new Date());
            subscriptionsDTO.setSeriousness(SeriousnessType._VERY_SERIOUS);
            subscriptionsDTO.setUser(user);
            subscriptionsDTO.setTopic(topicDAO.getTopicById(topicDAO.addTopic(topic)));
            return subscriptionService.subscribeTopic(subscriptionsDTO);
        } catch (Exception e) {
            System.out.print("addTop() in TopicServiceImpl; " + e);
            return 2;
        }
    }

    public TopicDTO getTopicDTO(int id) {
        TopicDTO topicDTO = new TopicDTO(topicDAO.getTopicById(id));
        return topicDTO;
    }

    public Topic getTopic(int id) {
        return (topicDAO.getTopicById(id));
    }

    public List<Topic> getAllTopics(int id) {
        return topicDAO.getAllTopicsCurrentUser(id);
    }


    public void changeVisibility() {
    }

    public void sendInvitation() {
    }

    public void updateTopicDetails() {
    }

    public void deleteTopic() {
    }


    public void searchTopics() {
    }

    public void viewPost() {
    }

    public void getAllTopicsCount() {
    }
}
