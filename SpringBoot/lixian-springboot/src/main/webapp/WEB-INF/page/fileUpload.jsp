<%--
  Created by IntelliJ IDEA.
  User: sand
  Date: 2018/11/21
  Time: 15:13
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
    <script src="<%=basePath%>/assets/js/fileUpload.js"></script>
</head>
<body>
<div>
    <form enctype="multipart/form-data" id="form">
        <span>表单普通数据：</span><input type="text" name="fieldData"/>
        <br/><br/>
        <span>选择上传文件：</span><input type="file" name="file"/>
        <br/><br/>
        <input type="button" value="提交" id="submit"/>
    </form>
</div>
</body>
</html>
