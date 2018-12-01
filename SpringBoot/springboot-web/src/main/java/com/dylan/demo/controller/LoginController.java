package com.dylan.demo.controller;

import com.dylan.demo.dao.LoginRepository;
import com.dylan.demo.entity.UserEntity;
import com.dylan.demo.vo.LoginRequestVo;
import com.dylan.demo.vo.LoginResultVo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //控制器类
public class LoginController {
    @Autowired //自动依赖注入 将刚才定义的仓库注入到控制器中
    LoginRepository loginRepository;

    @RequestMapping(value = "/login",method = { RequestMethod.POST})
    public LoginResultVo loginRequest(@RequestParam("data") String data){
        LoginResultVo loginResultVo = new LoginResultVo();
        try {
            Gson gson = new Gson();
            LoginRequestVo loginRequestVo = gson.fromJson(data,LoginRequestVo.class);
            int passwd = loginRequestVo.getUserphone();
            String username = loginRequestVo.getUsername();
            UserEntity usersEntity=loginRepository.findById(id);
            String password = usersEntity.getName();
            if (username.equals(password)){
                loginResultVo.setInfo(200);
                loginResultVo.setInfo("密码正确，登录成功");
            }else{
                loginResultVo.setInfo(400);
                loginResultVo.setInfo("密码错误，登录失败");
            }
            return loginResultVo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return loginResultVo;
    }
}

