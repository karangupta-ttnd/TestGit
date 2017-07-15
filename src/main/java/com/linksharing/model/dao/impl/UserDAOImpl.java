package com.linksharing.model.dao.impl;

import com.linksharing.dto.UserDTO;
import com.linksharing.model.dao.interfaces.UserDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karan on 11/7/17.
 */

@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveUser(UserDTO user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public UserDTO getUser(Integer id){
        return new UserDTO();
    }


}
