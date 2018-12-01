package com.dylan.demo.dao;

import com.dylan.demo.bean.User;

public interface UserMapper {
    User login(User user);
    void regist(User user);

    Integer getUserByUserName(String userName);

}
