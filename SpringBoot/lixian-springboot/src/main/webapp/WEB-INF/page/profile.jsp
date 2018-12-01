<%--
  Created by IntelliJ IDEA.
  User: 杨巨基
  Date: 2018/11/21
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/jsp;charset=UTF-8" language="java" %>
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
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#reports-dropdown" href="#"><i class="icon-signal"></i> Reports <b class="caret"></b></a>
					<ul id="reports-dropdown" class="collapse">
						<li><a href="report.jsp">Sales Reports</a></li>
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
				The profile template would be used to display an individual member's information.
			</div>
			
			<div class="row">
			
				<div class="span2 profileicon">
					
					<i class="icon icon-user"></i>
					
					<p><strong>Date Registered:</strong> 12th May 2014</p>
					<p><strong>Email Address:</strong> <a href="">johnsmith@johnsmith.com</a></p>
					
				</div>
				
				<div class="span8">
					
					<div class="row">
					
					<div class="span4">
					
						<div class="slate">
						
							<div class="page-header">
								<h2>Billing Address</h2>
							</div>
						
							<p>Joe Bloggs</p>
							<p>1 Long Road</p>
							<p>Small Town</p>
							<p>Big City</p>
							<p>Country</p>
							<p>ZIP/Postal Code</p>
						
						</div>
					
					</div>
				
					<div class="span4">
					
						<div class="slate">
						
							<div class="page-header">
								<h2>Delivery Address</h2>
							</div>
						
							<p>Joe Bloggs</p>
							<p>1 Long Road</p>
							<p>Small Town</p>
							<p>Big City</p>
							<p>Country</p>
							<p>ZIP/Postal Code</p>
						
						</div>
					
					</div>
					
					</div>
					
					<div class="row">
					
					<div class="span8">
				
						<div class="slate">
						
							<div class="page-header">
								<h2>Customer's Orders</h2>
							</div>
						
							<table class="orders-table table">
							<tbody>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-info">Paid</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-success">Dispatched</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-important">Refunded</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label">Awaiting Payment</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-inverse">Failed</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-warning">Cancelled</span></td>
									<td>$112.00</td>
								</tr>
								<tr>
									<td><a href="">#12345 - Joe Bloggs</a> <span class="label label-info">Paid</span></td>
									<td>$112.00</td>
								</tr>
							</tbody>
							</table>
	
						</div>
					
					</div>
					
					</div>
					
					<div class="row">
						
						<div class="span8">
						
							<div class="slate">
							
								<div class="page-header">
									<h2>Customer History</h2>
								</div>
							
								<table class="orders-table table">
								<thead>
									<tr>
										<th>Action</th>
										<th class="actions">Date</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Placed Order # 12345</td>
										<td class="date">
											Today at 14:55
										</td>
									</tr>
									<tr>
										<td>Registered</td>
										<td class="date">
											12th May 2014 at 13:42
										</td>
									</tr>
								</tbody>
								</table>
		
							</div>
						
						</div>
						
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



</body>
</html>