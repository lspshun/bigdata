package com.dylan.demo.service;

import com.dylan.demo.bean.User;

public interface UserService {

    User login(User user);

    void regist(User user);

}
