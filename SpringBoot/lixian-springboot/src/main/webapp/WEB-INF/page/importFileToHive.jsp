<%--
  Created by IntelliJ IDEA.
  User: sand
  Date: 2018/11/23
  Time: 11:54
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
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/reset.css">
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/importFileToHive.css">
    <script src="<%=basePath%>/assets/js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>/assets/js/importFileToHive.js"></script>
</head>
<body>
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
    <span>数据结构：</span>
    <label class="select"><input type="radio" name="structType" value="auto" /><span>自动识别</span></label>
    <label class="select"><input type="radio" name="structType" value="manual" /><span>手动指定</span></label>
    <br/><br/>
    <div id="manual" style="display: none"></div>
    <input type="button" value="提交" id="submit"/>
</form>
<!-- 定义列名和类型的模板 - 隐藏状态 -->
<div id="column" style="display: none">
    <span>列名:</span><input type="text" name="columnNames" />&nbsp;&nbsp;
    <span>类型:</span>
    <select name="columnTypes">
        <option name="string">String</option>
        <option name="bigint">bigint</option>
        <option name="double">double</option>
    </select>&nbsp;&nbsp;
    <span class="select plus">+</span>
</div>
</body>
</html>
