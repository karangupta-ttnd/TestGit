package com.linksharing.model.services.impl;

import com.linksharing.dto.SubscriptionsDTO;
import com.linksharing.dto.TopicDTO;
import com.linksharing.model.dao.impl.SubscriptionDAOImpl;
import com.linksharing.model.dao.interfaces.SubscriptionDAO;
import com.linksharing.model.entities.Subscriptions;
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
    SubscriptionDAO subscriptionDAO;

    public int getSubscribersCount() {
        return 0;
    }

    public int subscribeTopic(SubscriptionsDTO subscriptionsDTO) {
        try{
            subscriptionDAO.subscribeTopic(new Subscriptions(subscriptionsDTO));
            return 1;
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("subscribeTopic() in SubscriptionServiceImpl; ");
            return 2;
        }
    }

    public void unsubscribeTopic() {

    }
}
