package com.dylan.demo.service.impl;

import com.dylan.demo.bean.User;
import com.dylan.demo.dao.UserMapper;
import com.dylan.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    public User login(User user) {
        User u = mapper.login(user);
        return u;
    }

    public void regist(User user) {
        mapper.regist(user);
    }



}
