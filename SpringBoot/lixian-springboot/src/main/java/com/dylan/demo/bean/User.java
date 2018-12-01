package com.dylan.demo.bean;

public class User {
    private Integer userId;
    private String userLogin;
    private String userPwd;
    private String userName;
    private Integer userType;

    public User(Integer userId, String userLogin, String userPwd, String userName, Integer userType) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userType = userType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userLogin='" + userLogin + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                '}';
    }
}