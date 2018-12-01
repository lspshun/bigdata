<%--
  Created by IntelliJ IDEA.
  User: sand
  Date: 2018/11/26
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <script type="text/javascript">
        var basePath = '<%= basePath%>';
    </script>
    <script type="text/javascript" src="<%= basePath%>/assets/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%= basePath%>/assets/js/importRDBMSToHive.js"></script>
</head>
<body>
<div>
    <span>数据源名称：</span><input type="text" id="sourceName" />
    <br /><br />
    <span>数据源分组：</span>
    <select id="groupId">
        <option value="8">eight</option>
    </select>
    <br /><br />
    <form id="database">
        <input type="hidden" name="userId" value="${sessionScope.user.userId}" />
        <span>数据库类型：</span>
        <select name="type">
            <option value="-1">请选择</option>
            <option value="mysql">MySQL</option>
        </select>
        <br /><br />
        <span>主机名：</span><input type="text" name="host" />
        <br /><br />
        <span>访问端口：</span><input type="text" name="port" />
        <br /><br />
        <span>用户名：</span><input type="text" name="userName" />
        <br /><br />
        <span>密码：</span><input type="text" name="password" />
        <br /><br />
        <input type="button" id="testConnection" value="测试连接">
    </form>
</div>
<div id="databaseSelect">

</div>
<br />
<div id="dataTableSelect">

</div>
<br />
<div id="button">

</div>
</body>
</html>
