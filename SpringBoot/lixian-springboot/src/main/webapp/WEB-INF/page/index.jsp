<%--
  Created by IntelliJ IDEA.
  User: 杨巨基
  Date: 2018/11/21
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>大数据建模平台</title>

    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/admin.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <div class="row">

        <div class="span2">

            <div class="main-left-col">

                <h1><i class="icon-shopping-cart icon-large"></i> <br/>大数据建模平台</h1>

                <ul class="side-nav">

                    <li class="active">
                        <a ><i class="icon-home"></i> 功能菜单</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#website-dropdown" ><i class="icon-sitemap"></i> 数据源=>目标源 <b class="caret"></b></a>
                        <ul id="website-dropdown" class="collapse">
                            <li><a href="fileUpload">文件上传</a></li>
                            <li><a href="importFileToHDFS">导入文件到HDFS</a></li>
                            <li><a href="importFileToHive">导入文件到Hive</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#store-dropdown" ><i class="icon-shopping-cart"></i> RDBMS=>目标源 <b class="caret"></b></a>
                        <ul id="store-dropdown" class="collapse">
                            <li><a href="importRDBMSToHive">RDBMS文件导入Hive</a></li>
                            <li><a <%--href=""--%>>RDBMS文件导入HDFS</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#reports-dropdown" ><i class="icon-signal"></i> 结果集=>目标源 <b class="caret"></b></a>
                        <ul id="reports-dropdown" class="collapse">
                            <li><a <%--href=""--%>>结果文件导入HDFS</a></li>
                            <li><a <%--href=""--%>>结果表导入hive</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#members-dropdown" ><i class="icon-group"></i> 数据计算流程 <b class="caret"></b></a>
                        <ul id="members-dropdown" class="collapse">
                            <li><a <%--href=""--%>>数据计算<=>MR</a></li>
                            <li><a href="dataFlow">数据计算<=>HQL</a></li>
                            <li><a <%--href=""--%>>运行数据流程</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#settings-dropdown" ><i class="icon-cogs"></i> 结果展示 <b class="caret"></b></a>
                        <ul id="settings-dropdown" class="collapse">
                            <li><a <%--href=""--%>>结果=>图形化界面展示</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="collapse" data-target="#help-dropdown" ><i class="icon-info-sign"></i> 功能说明 <b class="caret"></b></a>
                        <ul id="help-dropdown" class="collapse">
                        </ul>
                    </li>
                </ul>

            </div> <!-- end main-left-col -->

        </div> <!-- end span2 -->

        <div class="span10">

            <div class="secondary-masthead">

                <ul class="nav nav-pills pull-right">
                    <li>
                        <a ><i class="icon-globe"></i> View Website</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" ><i class="icon-user"></i> John Smith <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="divider"></li>
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    </li>
                </ul>

                <ul class="breadcrumb">
                    <li>
                        <a >Admin</a> <span class="divider">/</span>
                    </li>
                    <li class="active">Dashboard</li>
                </ul>

            </div>

            <div class="main-area dashboard">

                <div class="row">

                    <div class="span10">

                        <div class="slate clearfix">

                            <a class="stat-column" >

                                <span class="number">16</span>
                                <span>Open Orders</span>

                            </a>

                            <a class="stat-column" >

                                <span class="number">452</span>
                                <span>Members</span>

                            </a>

                            <a class="stat-column" >

                                <span class="number">$2,512</span>
                                <span>Revenue</span>

                            </a>

                            <a class="stat-column" >

                                <span class="number">348</span>
                                <span>Subscribers</span>

                            </a>

                        </div>

                    </div>

                </div>

                <div class="row">

                    <div class="span5">

                        <div class="slate">

                            <div class="page-header">
                                <h2><i class="icon-signal pull-right"></i>Stats</h2>
                            </div>
                            <div id="placeholder" style="height: 297px;"></div>

                        </div>

                    </div>

                    <div class="span5">

                        <div class="slate">

                            <div class="page-header">
                                <h2><i class="icon-shopping-cart pull-right"></i>Latest Orders</h2>
                            </div>

                            <table class="orders-table table">
                                <tbody>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-info">Paid</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-success">Dispatched</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-important">Refunded</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label">Awaiting Payment</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-inverse">Failed</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-warning">Cancelled</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td><a >#12345 - Joe Bloggs</a> <span class="label label-info">Paid</span></td>
                                    <td>$112.00</td>
                                </tr>
                                <tr>
                                    <td colspan="2"><a >View more orders</a></td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div>

                </div>

                <div class="row">

                    <div class="span5">

                        <div class="slate">

                            <div class="page-header">
                                <h2><a class="pull-right iconlink" ><i class="icon-rss"></i></a>News</h2>
                            </div>

                            <table class="orders-table table">
                                <tbody>
                                <tr>
                                    <td><a >News article title</a></td>
                                    <td class="date">Today at 12:01</td>
                                </tr>
                                <tr>
                                    <td><a >Another news article title</a></td>
                                    <td class="date">Yesterday at 16:34</td>
                                </tr>
                                <tr>
                                    <td><a >A third news article title</a></td>
                                    <td class="date">22nd June 2014</td>
                                </tr>
                                <tr>
                                    <td><a >This news article title spans onto two lines so we can see what it will look like</a></td>
                                    <td class="date">21st June 2014</td>
                                </tr>
                                <tr>
                                    <td><a >A final news article title</a></td>
                                    <td class="date">20th June 2014</td>
                                </tr>
                                <tr>
                                    <td colspan="2"><a >Read more news</a></td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div>

                    <div class="span5">

                        <div class="slate">

                            <div class="page-header">
                                <h2><i class="icon-envelope-alt pull-right"></i>Enquiries</h2>
                            </div>

                            <table class="orders-table table">
                                <tbody>
                                <tr>
                                    <td><a >Customer enquiry</a> <span class="label label-info">New</span></td>
                                    <td class="date">Today at 12:01</td>
                                </tr>
                                <tr>
                                    <td><a >Another customer enquiry</a> <span class="label label-info">New</span></td>
                                    <td class="date">Yesterday at 16:34</td>
                                </tr>
                                <tr>
                                    <td><a >A third customer enquiry</a></td>
                                    <td class="date">22nd June 2014</td>
                                </tr>
                                <tr>
                                    <td><a >This customer enquiry spans onto two lines so we can see what it will look like</a></td>
                                    <td class="date">21st June 2014</td>
                                </tr>
                                <tr>
                                    <td><a >A final customer enquiry</a></td>
                                    <td class="date">20th June 2014</td>
                                </tr>
                                <tr>
                                    <td colspan="2"><a >View more enquiries</a></td>
                                </tr>
                                </tbody>
                            </table>

                        </div>

                    </div>

                </div>

                <div class="row">

                    <div class="span10 footer">

                        <p>&copy; Website Name 2014</p>

                    </div>

                </div>

            </div>

        </div> <!-- end span10 -->

    </div> <!-- end row -->

</div> <!-- end container -->

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/excanvas.min.js"></script>
<script src="assets/js/jquery.flot.min.js"></script>
<script src="assets/js/jquery.flot.resize.js"></script>
<script type="text/javascript">
    $(function () {
        var d1 = [];
        d1.push([0, 32]);
        d1.push([1, 30]);
        d1.push([2, 24]);
        d1.push([3, 17]);
        d1.push([4, 11]);
        d1.push([5, 25]);
        d1.push([6, 28]);
        d1.push([7, 36]);
        d1.push([8, 44]);
        d1.push([9, 52]);
        d1.push([10, 53]);
        d1.push([11, 50]);
        d1.push([12, 45]);
        d1.push([13, 42]);
        d1.push([14, 40]);
        d1.push([15, 36]);
        d1.push([16, 34]);
        d1.push([17, 24]);
        d1.push([18, 17]);
        d1.push([19, 17]);
        d1.push([20, 20]);
        d1.push([21, 28]);
        d1.push([22, 36]);
        d1.push([23, 38]);

        $.plot($("#placeholder"), [ d1 ], { grid: { backgroundColor: 'white', color: '#999', borderWidth: 1, borderColor: '#DDD' }, colors: ["#FC6B0A"], series: { lines: { show: true, fill: true, fillColor: "rgba(253,108,11,0.4)" } } });
    });
</script>


</body>
</html>