<%--
  Created by IntelliJ IDEA.
  User: sand
  Date: 2018/11/26
  Time: 22:01
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
    <script src="<%=basePath%>/assets/js/dataFlow.js"></script>
</head>
<body>
<div>
    <span>选择数据源类型：</span>
    <select id="sourceSelect">
        <option value="-1">请选择</option>
        <option value="hdfs">HDFS</option>
        <option value="hive">Hive</option>
    </select>
    <br/><br/>
    <span>选择数据源：</span>
    <select id="hiveSource">
        <option value="-1">请选择</option>
    </select>
    <br/><br/>
    <input id="showColumn" type="button" value="表结构预览"/>
    <input id="showData" type="button" value="数据预览"/>
</div>
<div id="tableColumn">

</div>
<div id="tableData">
</div>
<form id="dataFlowForm">
    <span>数据流程名称：</span><input type="text" name="dataFlowName" />
    <br/><br/>
    <label><input type="radio" name="type" value="sum">累加(sum)</label>
    <label><input type="radio" name="type" value="count">计数(count)</label>
    <br/><br/>
    <span>结果列：</span><input type="text" name="resultColumn"/>
    <br/><br/>
    <span>函数作用列：</span><input type="text" name="functionColumn"/>
    <br/><br/>
    <span>分组列：</span><input type="text" name="groupColumn"/>
    <br/><br/>
    <input type="button" id="submit" value="新建数据流程"/>
</form>
</body>
</html>
