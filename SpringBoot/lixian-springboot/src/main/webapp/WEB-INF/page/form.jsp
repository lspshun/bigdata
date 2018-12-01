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
				<li class="dropdown active">
					<a class="dropdown-toggle" data-toggle="collapse" data-target="#website-dropdown" href="#"><i class="icon-sitemap"></i> Website <b class="caret"></b></a>
					<ul id="website-dropdown">
						<li class="active"><a href="listing.jsp">Pages</a></li>
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
				This template shows how forms can be laid out for editing content.
			</div>

			<div class="alert alert-error">
				<a class="close" data-dismiss="alert" href="#">x</a>
				<h4 class="alert-heading">Error</h4>
				Example of an error message alert.
			</div>

			<div class="alert alert-success">
				<a class="close" data-dismiss="alert" href="#">x</a>
				<h4 class="alert-heading">Success</h4>
				Example of an success message alert.
			</div>

			<div class="alert alert-warning">
				<a class="close" data-dismiss="alert" href="#">x</a>
				<h4 class="alert-heading">Warning</h4>
				Example of an warning message alert.
			</div>

			<div class="row">

				<div class="span10">

					<div class="slate">

						<form class="form-inline">
							<input type="text" class="input-large" placeholder="Keywords...">
							<select class="span2">
								<option value=""> - From Date - </option>
							</select>
							<select class="span2">
								<option value=""> - To Date - </option>
							</select>
							<select class="span2">
								<option value=""> - Filter - </option>
							</select>
							<button type="submit" class="btn btn-primary">Filter</button>
						</form>

					</div>

				</div>

			</div>

			<div class="row">

				<div class="span10 listing-buttons">

					<button class="btn btn-info">Action</button>

					<button class="btn btn-success">Action</button>

					<button class="btn btn-primary">Add New Order</button>

				</div>

				<div class="span10">

					<div class="slate">

						<div class="page-header">
							<h2>Form Title</h2>
						</div>

						<form class="form-horizontal">
						<fieldset>
						  <div class="control-group">
						    <label class="control-label" for="focusedInput">Focused input</label>
						    <div class="controls">
						      <input class="input-xlarge focused" id="focusedInput" type="text" value="This is focused�?>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label">Uneditable input</label>
						    <div class="controls">
						      <span class="input-xlarge uneditable-input">Some value here</span>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="disabledInput">Disabled input</label>
						    <div class="controls">
						      <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="Disabled input here�? disabled>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="optionsCheckbox2">Disabled checkbox</label>
						    <div class="controls">
						      <label class="checkbox">
						        <input type="checkbox" id="optionsCheckbox2" value="option1" disabled>
						        This is a disabled checkbox
						      </label>
						    </div>
						  </div>
						  <div class="control-group warning">
						    <label class="control-label" for="inputWarning">Input with warning</label>
						    <div class="controls">
						      <input type="text" id="inputWarning">
						      <span class="help-inline">Something may have gone wrong</span>
						    </div>
						  </div>
						  <div class="control-group error">
						    <label class="control-label" for="inputError">Input with error</label>
						    <div class="controls">
						      <input type="text" id="inputError">
						      <span class="help-inline">Please correct the error</span>
						    </div>
						  </div>
						  <div class="control-group success">
						    <label class="control-label" for="inputSuccess">Input with success</label>
						    <div class="controls">
						      <input type="text" id="inputSuccess">
						      <span class="help-inline">Woohoo!</span>
						    </div>
						  </div>
						  <div class="control-group success">
						    <label class="control-label" for="selectError">Select with success</label>
						    <div class="controls">
						      <select id="selectError">
						        <option>1</option>
						        <option>2</option>
						        <option>3</option>
						        <option>4</option>
						        <option>5</option>
						      </select>
						      <span class="help-inline">Woohoo!</span>
						    </div>
						  </div>
						</fieldset>
						</form>

					</div>

				</div>

				<div class="span5">

					<div class="slate">

						<div class="page-header">
							<h2>Form Title</h2>
						</div>

						<form class="form-horizontal">
						<fieldset>
						  <div class="control-group">
						    <label class="control-label" for="input01">Text input</label>
						    <div class="controls">
						      <input type="text" class="input-xlarge" id="input01">
						      <p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="optionsCheckbox">Checkbox</label>
						    <div class="controls">
						      <label class="checkbox">
						        <input type="checkbox" id="optionsCheckbox" value="option1">
						        Option one is this and that&mdash;be sure to include why it's great
						      </label>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="select01">Select list</label>
						    <div class="controls">
						      <select id="select01">
						        <option>something</option>
						        <option>2</option>
						        <option>3</option>
						        <option>4</option>
						        <option>5</option>
						      </select>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="multiSelect">Multicon-select</label>
						    <div class="controls">
						      <select multiple="multiple" id="multiSelect">
						        <option>1</option>
						        <option>2</option>
						        <option>3</option>
						        <option>4</option>
						        <option>5</option>
						      </select>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="fileInput">File input</label>
						    <div class="controls">
						      <input class="input-file" id="fileInput" type="file">
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="textarea">Textarea</label>
						    <div class="controls">
						      <textarea class="input-xlarge" id="textarea" rows="3"></textarea>
						    </div>
						  </div>
						</fieldset>
						</form>

					</div>

				</div>

				<div class="span5">

					<div class="slate">

						<div class="page-header">
							<h2>Form Title</h2>
						</div>

						<form class="form-horizontal">
						<fieldset>
						  <div class="control-group">
						    <label class="control-label" for="input01">Text input</label>
						    <div class="controls">
						      <input type="text" class="input-xlarge" id="input01">
						      <p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="optionsCheckbox">Checkbox</label>
						    <div class="controls">
						      <label class="checkbox">
						        <input type="checkbox" id="optionsCheckbox" value="option1">
						        Option one is this and that&mdash;be sure to include why it's great
						      </label>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="select01">Select list</label>
						    <div class="controls">
						      <select id="select01">
						        <option>something</option>
						        <option>2</option>
						        <option>3</option>
						        <option>4</option>
						        <option>5</option>
						      </select>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="multiSelect">Multicon-select</label>
						    <div class="controls">
						      <select multiple="multiple" id="multiSelect">
						        <option>1</option>
						        <option>2</option>
						        <option>3</option>
						        <option>4</option>
						        <option>5</option>
						      </select>
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="fileInput">File input</label>
						    <div class="controls">
						      <input class="input-file" id="fileInput" type="file">
						    </div>
						  </div>
						  <div class="control-group">
						    <label class="control-label" for="textarea">Textarea</label>
						    <div class="controls">
						      <textarea class="input-xlarge" id="textarea" rows="3"></textarea>
						    </div>
						  </div>
						</fieldset>
						</form>

					</div>

				</div>

				<div class="span10 listing-buttons">

					<button class="btn btn-info">Action</button>

					<button class="btn btn-success">Action</button>

					<button class="btn btn-primary">Add New Item</button>

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

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>


</body>
</html>