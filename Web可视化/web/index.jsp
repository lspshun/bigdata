
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>$Title$</title>
    <!-- 1.引入资源文件 -->
    <script type="text/javascript" src="js/echarts.min.js"></script>
    <script type="text/javascript">
        var basePath = '<%= basePath%>';
    </script>
  </head>
  <body>
    <%-- 2.指定图表生成区域 --%>
    <div id="main" style="height: 400px;width: 600px"></div>
  </body>
  <script type="text/javascript" src="js/index.js"></script>
</html>
