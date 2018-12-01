<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="assets/css/regist.css">
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#in_put").blur(function() {
                var userName = $("#in_put").val();

                var url = "getUserByUserName";

                var json = {"userName": userName};

                $.post(url, json, function (data) {

                    if (data.count > 0) {
                        $("#useracc_msg").html("该用户已存在，请重新输入！");
                        return false;
                    } else {
                        $("#useracc_msg").html("");
                        return true;
                    }

                }, "json");
            })

            $("#ys").click(function () {
                if ($("#useracc_msg").html() != "") {
                    $("#useracc_msg").html("该用户已存在，请重新输入！");
                    return false;
                } else {
                    $("#useracc_msg").html("");
                    return true;
                }

            })
        })
    </script>
</head>
<body>
<div class="wrapper">
    <article>
        <h1><span>大数据建模平台</span></h1>
        <div class="main">
            <form action="regist" method="post">
                <div class="userName">
                    <input type="text" id="in_put" name="userName" placeholder="用户名"><em>由5-8个字符组成！</em><span
                        id="useracc_msg" style="color: red"></span>
                </div>
                <div class="password">
                    <input type="password" name="userPwd" placeholder="密码"><em>使用字母、数字、符号两种及以上的组合，6-12个字符</em>
                </div>
                <button id="ys" type="submit">注册</button>
            </form>
        </div>
    </article>
</div>
</body>
</html>
