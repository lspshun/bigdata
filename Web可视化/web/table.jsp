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
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript" src="js/table.js"></script>
</head>
<body>
    <%--<input name="tableName" type="text" placeholder="请输入数据表名称" />--%>
    <div id="dataInfo"></div>
    <input type="button" value="构建图表" />
    <div id="tableInfo"></div>
    <div id="main" style="height: 800px;width: auto"></div>
    <div id="pie" style="height: 800px;width: auto"></div>
</body>
</html>
