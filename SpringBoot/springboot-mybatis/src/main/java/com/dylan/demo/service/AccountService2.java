package com.dylan.demo.service;

import com.dylan.demo.dao.AccountMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService2 {
    @Autowired
    AccountMapper2 accountMapper2;

    // TODO: 2018/11/28 @Transactional注解开启了事物
    @Transactional
    public void transfer(){
        accountMapper2.update(80,1); //用户1减10块 用户2加10块
        // 设置事物报错的地方 失败两者都失败  全部成功才成功
//        int i=1/0;
        accountMapper2.update(110,2);

    }

}
