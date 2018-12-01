<%--
  Created by IntelliJ IDEA.
  User: sand
  Date: 2018/11/22
  Time: 14:37
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
    <script src="<%=basePath%>/assets/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>/assets/js/importFileToHDFS.js"></script>
</head>
<body>
<div>
    <form enctype="multipart/form-data" id="form">
        <input type="hidden" name="userId" value="${sessionScope.user.userId}" />
        <span>数据源名称：</span><input type="text" name="sourceName" />
        <br/><br/>
        <span>数据源分组：</span>
        <select name="groupId">
            <option value="8">eight</option>
        </select>
        <br/><br/>
        <span>选择上传文件：</span><input type="file" name="file"/>
        <br/><br/>
        <input type="button" value="提交" id="submit"/>
    </form>
</div>
</body>
</html>
