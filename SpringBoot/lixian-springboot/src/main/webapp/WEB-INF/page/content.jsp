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
				<li class="dropdown active">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#help-dropdown" href="#"><i class="icon-info-sign"></i> Help <b class="caret"></b></a>
					<ul id="help-dropdown">
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
				The content template gives examples of generic text content formatting.
			</div>
			
			<div class="row">
				
				<div class="span10">
				
					<div class="slate">
						
						<div class="page-header">
							<h1>H1 Page Title</h1>
							<h2>H2 Page Title</h2>
							<h3>H3 Page Title</h3>
							<h4>H4 Page Title</h4>
							<h5>H5 Page Title</h5>
							<h6>H6 Page Title</h6>
						</div>
						
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eget quam sit amet nisl dictum blandit. Sed cursus arcu eu libero posuere suscipit. Pellentesque ultricies, sem at varius aliquam, neque sapien placerat orci, a consequat elit neque suscipit velit. In sed ipsum elit. Vivamus nec orci nisi, ac vehicula dui. Donec lacinia nunc nec nulla egestas eget interdum ligula ullamcorper. Curabitur a tortor et nisi feugiat eleifend sit amet quis ligula. Suspendisse eu hendrerit turpis. Nullam at nisi sed urna dignissim mollis. Integer quis turpis vel nisi mollis fringilla ac in magna. Duis tempus dolor in nisi tristique bibendum.</p>
						
						<ul>
							<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
							<li>Nullam non massa sit amet nunc consectetur venenatis in sit amet turpis.</li>
							<li>Cras imperdiet elit ut mauris commodo varius.</li>
							<li>Vestibulum quis mi non tortor mattis volutpat sit amet feugiat augue.</li>
							<li>Etiam pharetra ipsum et nulla semper eleifend.</li>
							<li>Fusce commodo sapien at tortor rutrum ultrices.</li>
						</ul>
						
						<p>Sed fermentum metus rutrum metus sagittis vel rhoncus dui congue. Suspendisse elementum nisl et ante fermentum elementum. Phasellus vitae dui vel risus venenatis vestibulum. Quisque tellus erat, volutpat non tempus in, consectetur imperdiet nisl. Mauris feugiat, nibh vitae malesuada sollicitudin, dolor ipsum sodales neque, ut ultricies lorem magna et ante. In porttitor quam semper turpis faucibus dictum. Donec imperdiet, purus nec condimentum varius, diam augue posuere erat, vitae rutrum lacus erat et nibh. Nam a massa at dui sodales lobortis ut quis ante.</p>
						
						<ol>
							<li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
							<li>Nullam non massa sit amet nunc consectetur venenatis in sit amet turpis.</li>
							<li>Cras imperdiet elit ut mauris commodo varius.</li>
							<li>Vestibulum quis mi non tortor mattis volutpat sit amet feugiat augue.</li>
							<li>Etiam pharetra ipsum et nulla semper eleifend.</li>
							<li>Fusce commodo sapien at tortor rutrum ultrices.</li>
						</ol>
						
						<p>In hac habitasse platea dictumst. Phasellus in magna augue, vel lobortis tellus. Pellentesque commodo pharetra nisl. Etiam quis egestas sapien. Donec pretium mauris nec sapien tincidunt porta. Aliquam eget libero hendrerit nulla ornare interdum. In et justo eros, sed aliquet mauris. Nunc semper gravida augue, in rhoncus lorem eleifend quis. Ut feugiat, lacus ac facilisis tristique, nulla felis dictum dui, vitae fringilla dolor turpis in magna. Vestibulum vel risus non justo sollicitudin malesuada. Nunc sem diam, dictum vitae viverra ac, hendrerit sed risus. Cras interdum sem non augue commodo condimentum. Integer ut est eu dolor fringilla pretium.</p>
					
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