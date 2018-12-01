<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="assets/css/login.css">
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url(assets/img/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(assets/assetsimg/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(assets/img/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(assets/img/password1.png)"});
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="wrap">
            <header><em>qf</em><span>大数据建模平台</span></header>
            <article>
                <section>
                    <aside>
                        <em>
                            <img src="assets/img/user.png">
                        </em>
                         <form action="login" method="post">
                            <p class="name"><i></i><input id="userId" name="userName" type="text" class="form-control" placeholder="请输入账号" /></p>
                            <p class="password"><i></i><input id="userPw" name="userPwd" type="password" class="form-control" placeholder="请输入密码" /></p>
                            <button type="submit">登录</button>
                            <p class="regist"><span>没有账号?</span><a href="regist.jsp">立即注册</a></p>
                            <div class="clear"></div>
                        </form>
                    </aside>
                   
                </section>               
            </article>
        </div>
    </div>
</body>
</html>
