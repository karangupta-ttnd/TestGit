package com.linksharing.model.services.impl;

import com.linksharing.dto.TopicDTO;
import com.linksharing.model.services.interfaces.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karan on 20/7/17.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionService subscriptionService;


    public int getSubscribersCount() {
        return 0;
    }

    public TopicDTO subscribeTopic() {
        return null;
    }

    public void unsubscribeTopic() {

    }
}
