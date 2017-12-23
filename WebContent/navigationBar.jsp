<%@page import="tsc.web.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/sb-admin.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body onload="prepareNavBar()">

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Testing Center
					Scheduler</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown">
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>

						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav" id="navOptions">


					<li><a
						href="${pageContext.request.contextPath}/control/appointment.do?method=goTomakeAppointment"
						target="mainarea"> <i class="fa fa-desktop fa-2x"></i>Make
							Appointment
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/makeRequest.jsp"
						target="mainarea"> <em class="fa fa-edit fa-2x"></em>Make
							Request
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/viewAppointment.jsp"
						target="mainarea"><i class="fa fa-table fa-2x"></i> View
							Appointment</a></li>

					<li><a
						href="${pageContext.request.contextPath}/viewRequest.jsp"
						target="mainarea"><i class="fa fa-table fa-2x"></i> View
							Request</a></li>

					<li><a
						href="${pageContext.request.contextPath}/approveOrDeny.jsp"
						target="mainarea"> <em class="fa fa-check fa-2x"></em>
							Approve/Deny Request
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/displayUtilization.jsp"
						target="mainarea"> <em class="fa fa-line-chart fa-2x"></em>
							Display Utilization
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/attendence.jsp"
						target="mainarea"> <em class="fa fa-mortar-board fa-2x"></em>
							Attendance
					</a></li>
					<li><a href="${pageContext.request.contextPath}/checkIn.jsp"
						target="mainarea"> <em class="fa fa-calendar-check-o fa-2x"></em>
							Check-In
					</a></li>

					<li><a
						href="${pageContext.request.contextPath}/editTestingCenter.jsp"
						target="mainarea"> <em class="fa fa-gear fa-2x"></em> Edit
							Testing Center
					</a></li>

					<li><a href="${pageContext.request.contextPath}/import.jsp"
						target="mainarea"> <em class="fa fa-cloud-upload fa-2x"></em>
							Import Data
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/feedback_Failure.jsp"
						target="mainarea"> <em class="fa fa-download fa-2x"></em>
							Generate Report
					</a></li>
					<% UserBean user = (UserBean) request.getSession().getAttribute("user"); %>
					<div id="roleNumber" display="none"><%=user.getRole()%></div>





				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>


		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	<script Language="JavaScript">
		function prepareNavBar() {
		//	alert(document.getElementById("roleNumber").innerHTML);
			document.getElementById("navOptions").children[0].style.display = "none";
			document.getElementById("navOptions").children[1].style.display = "none";
			document.getElementById("navOptions").children[2].style.display = "none";
			document.getElementById("navOptions").children[3].style.display = "none";
			document.getElementById("navOptions").children[4].style.display = "none";
			document.getElementById("navOptions").children[5].style.display = "none";
			document.getElementById("navOptions").children[6].style.display = "none";
			document.getElementById("navOptions").children[7].style.display = "none";
			document.getElementById("navOptions").children[8].style.display = "none";
			document.getElementById("navOptions").children[9].style.display = "none";
			document.getElementById("navOptions").children[10].style.display = "none"; 
		
			if (document.getElementById("roleNumber").innerHTML == 1) {
				document.getElementById("navOptions").children[0].style.display = "block";
				document.getElementById("navOptions").children[2].style.display = "block";
			
			}
			else if (document.getElementById("roleNumber").innerHTML == 2) {
				document.getElementById("navOptions").children[1].style.display = "block";
				document.getElementById("navOptions").children[3].style.display = "block";
				document.getElementById("navOptions").children[6].style.display = "block";
			}
			else if (document.getElementById("roleNumber").innerHTML == 3) {
				document.getElementById("navOptions").children[0].style.display = "block";
				document.getElementById("navOptions").children[2].style.display = "block";
				document.getElementById("navOptions").children[3].style.display = "block";
				document.getElementById("navOptions").children[4].style.display = "block";
				document.getElementById("navOptions").children[5].style.display = "block";
				document.getElementById("navOptions").children[6].style.display = "block";
				document.getElementById("navOptions").children[7].style.display = "block";
				document.getElementById("navOptions").children[8].style.display = "block";
				document.getElementById("navOptions").children[9].style.display = "block";
				document.getElementById("navOptions").children[10].style.display = "block";
			} 
		}
	</script>
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>

</body>

</html>

