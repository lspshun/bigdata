package com.dylan.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// 返回json需要@ResponseBody和@Controller配合   RestController代替了
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "creat from springboot";
    }

}