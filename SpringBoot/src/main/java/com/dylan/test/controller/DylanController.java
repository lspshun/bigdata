package com.dylan.test.controller;

import com.dylan.test.bean.ConfigBean;
import com.dylan.test.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class DylanController {
    @Autowired
    ConfigBean configBean;
    @RequestMapping("/dylan")
    public String test(){
        return  configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    User user;
    @RequestMapping("/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
