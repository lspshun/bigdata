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
    <title>686 Adminize</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/admin.css" rel="stylesheet">
    
</head>    
<body>

<div class="container">
		
	<div class="row">
		
		<div class="span2">
		
		<div class="main-left-col">
		
			<h1><i class="icon-shopping-cart icon-large"></i> Adminize</h1>
			
			<ul class="side-nav">

				<li>
					<a href="index.jsp"><i class="icon-home"></i> Dashboard</a>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#website-dropdown" href="#"><i class="icon-sitemap"></i> Website <b class="caret"></b></a>
					<ul id="website-dropdown" class="collapse">
						<li><a href="listing.jsp">Pages</a></li>
						<li><a href="listing.jsp">Menus</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#store-dropdown" href="#"><i class="icon-shopping-cart"></i> Store <b class="caret"></b></a>
					<ul id="store-dropdown" class="collapse">
						<li><a href="listing.jsp">Catalogue</a></li>
						<li><a href="orders.jsp">Orders</a></li>
						<li><a href="listing.jsp">Enquiries</a></li>
					</ul>
				</li>
				<li class="dropdown active">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#reports-dropdown" href="#"><i class="icon-signal"></i> Reports <b class="caret"></b></a>
					<ul id="reports-dropdown">
						<li class="active"><a href="report.jsp">Sales Reports</a></li>
						<li><a href="report.jsp">Product Popularity</a></li>
						<li><a href="report.jsp">Member Registrations</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#members-dropdown" href="#"><i class="icon-group"></i> Members <b class="caret"></b></a>
					<ul id="members-dropdown" class="collapse">
						<li><a href="listing.jsp">Members</a></li>
						<li><a href="listing.jsp">User Groups</a></li>
						<li><a href="listing.jsp">Permissions</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#settings-dropdown" href="#"><i class="icon-cogs"></i> Settings <b class="caret"></b></a>
					<ul id="settings-dropdown" class="collapse">
						<li><a href="listing.jsp">Payment Processors</a></li>
						<li><a href="listing.jsp">Order Statuses</a></li>
						<li><a href="listing.jsp">Shipping Methods</a></li>
						<li><a href="listing.jsp">Emails</a></li>
					</ul>
				</li>
				<li><a href="#"><i class="icon-bullhorn"></i> Alerts <span class="badge badge-warning">2</span></a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#help-dropdown" href="#"><i class="icon-info-sign"></i> Help <b class="caret"></b></a>
					<ul id="help-dropdown" class="collapse">
						<li><a href="content.jsp">FAQ</a></li>
						<li class="active"><a href="content.jsp">User Guide</a></li>
						<li><a href="content.jsp">Support</a></li>
					</ul>
				</li>
			</ul>
		
		</div> <!-- end main-left-col -->
	
	</div> <!-- end span2 -->
	
	<div class="span10">
		
	<div class="secondary-masthead">
	
		<ul class="nav nav-pills pull-right">
			<li>
				<a href="#"><i class="icon-globe"></i> View Website</a>
			</li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="icon-user"></i> John Smith <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="profile.jsp">Your Profile</a></li>
					<li class="active"><a href="form.jsp">Account Settings</a></li>
					<li class="divider"></li>
					<li><a href="">Logout</a></li>
				</ul>
			</li>
		</ul>

		<ul class="breadcrumb">
			<li>
				<a href="#">Admin</a> <span class="divider">/</span>
			</li>
			<li class="active">Dashboard</li>
		</ul>
		
	</div>
	
	<div class="main-area dashboard">
	
			<div class="alert alert-info">
				<a class="close" data-dismiss="alert" href="#">x</a>
				<h4 class="alert-heading">Information</h4>
				The report template can be used to display charts and report data, such as sales reports, website stats and member sign ups.
			</div>
			
			<div class="row">
			
				<div class="span10">
				
					<div class="slate">
					
						<form class="form-inline">
							<input type="text" class="input-large" placeholder="Keyword...">
							<select class="span2">
								<option value=""> - From Date - </option>
							</select>
							<select class="span2">
								<option value=""> - To Date - </option>
							</select>
							<select class="span2">
								<option value=""> - Filter - </option>
							</select>
							<button type="submit" class="btn btn-primary">Filter Report</button>
						</form>
					
					</div>
				
				</div>
			
			</div>
			
			<div class="row">
			
				<div class="span10">
				
					<div class="slate">
					
						<div class="page-header">
							<h2><i class="icon-signal pull-right"></i>Sales Report</h2>
						</div>
						<div id="placeholder" style="height: 400px;"></div>
					
					</div>
				
				</div>
			
			</div>
			
			<div class="row">
			
				<div class="span10">
				
					<div class="slate">
					
						<div class="page-header">
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									<i class="icon-download-alt"></i> Export
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="">CSV</a></li>
									<li><a href="">Excel</a></li>
									<li><a href="">PDF</a></li>
								</ul>
							</div>
							<h2>Report Data</h2>
						</div>
					
						<table class="orders-table table">
						<thead>
							<tr>
								<th>Day</th>
								<th class="value">Order Value</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Today</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>Yesterday</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>5th June 2014</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>4th June 2014</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>3rd June 2014</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>2nd June 2014</td>
								<td class="value">$124.00</td>
							</tr>
							<tr>
								<td>1st June 2014</td>
								<td class="value">$124.00</td>
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