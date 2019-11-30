
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Start Bootstrap - SB Admin Version 2.0 Demo</title>

<!-- Core CSS - Include with every page -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">

<!-- Page-Level Plugin CSS - Tables -->
<link
	href="<%=request.getContextPath()%>/resources/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- SB Admin CSS - Include with every page -->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin.css"
	rel="stylesheet">

</head>

<body>

	<div id="wrapper">

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">SB Admin v2.0</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<sec:authorize
					access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGE','ROLE_USER')">
					<li>
						<form action="/member/logout" method='post' id="frm">
							<a href="#" onclick="document.getElementById('frm').submit()">Logout</a>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</li>
					<li><a href="/member/mypage">My Page</a></li>
				</sec:authorize>

				<sec:authorize access="isAnonymous()">
					<li><a href="/member/register">register</a></li>
					<li><a href="/member/loginForm">Login</a></li>
				</sec:authorize>
				
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default navbar-static-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</li>
						<li><a href="/map/index"><i class="fa fa-dashboard fa-fw"></i>
								Smoking Area</a></li>
						<li><a href="#"><i class="fa fa-wrench fa-fw"></i>
								Component List<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="/component/brand/list">Brand</a></li>
								<li><a href="/component/company/list">Company</a></li>
								<li><a href="/component/country/list">Country</a></li>
								<li><a href="/component/type/list">Type</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="/tobacco/list"><i class="fa fa-table fa-fw"></i>
								Tobacco List</a></li>
						<li><a href="/misc/info"><i class="fa fa-edit fa-fw"></i>
								Info<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="/misc/notice/list">Notice</a></li>
								<li><a href="/misc/news/list">NEWS</a></li>
								<li><a href="/misc/info/list">Info</a></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
					<!-- /#side-menu -->
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<div id="page-wrapper">