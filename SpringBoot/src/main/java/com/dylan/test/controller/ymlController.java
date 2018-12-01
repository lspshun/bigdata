package com.dylan.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ymlController {
    // TODO: 2018/11/28  读取配置文件加@Value("${属性名}")
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping("/yml")
    public String yml() {
        return name + ":" + age;
    }
}
