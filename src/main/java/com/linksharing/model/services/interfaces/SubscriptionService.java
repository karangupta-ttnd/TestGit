package com.linksharing.model.services.interfaces;

import com.linksharing.dto.SubscriptionsDTO;
import com.linksharing.dto.TopicDTO;

/**
 * Created by karan on 20/7/17.
 */
public interface SubscriptionService {

    int getSubscribersCount();
    int subscribeTopic(SubscriptionsDTO subscriptionsDTO);
    void unsubscribeTopic();

}