<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:include page="navigationBar.jsp"></jsp:include>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>

<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->


		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Approve/Deny Request</h1>

					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12"></div>
				</div>
				<!-- /.row -->

				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2 class="panel-title">
									<em class="fa fa-bar-chart-o fa-fw"></em>
								</h2>
							</div>
							<div class="table-responsive">
								<table class="table table-hover table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>Exam</th>
											<th>Course</th>
											<th>Professor</th>
											<th>Request Seats</th>
											<th>Date</th>
										</tr>
									</thead>
									<tbody id="myTable">
										<tr>
											<td>1</td>
											<td>Midterm</td>
											<td>CSE114</td>
											<td>Prof.A</td>
											<td>64</td>
											<td>10/10/2015 1 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>

										<tr>
											<td>2</td>
											<td>Final</td>
											<td>CSE214</td>
											<td>Prof.A</td>
											<td>24</td>
											<td>10/15/2015 3 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>3</td>
											<td>Midterm</td>
											<td>CSE308</td>
											<td>Prof.A</td>
											<td>54</td>
											<td>10/18/2015 2 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>4</td>
											<td>Midterm</td>
											<td>CSE308</td>
											<td>Prof.A</td>
											<td>54</td>
											<td>10/18/2015 2 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>5</td>
											<td>Midterm</td>
											<td>CSE308</td>
											<td>Prof.A</td>
											<td>54</td>
											<td>10/18/2015 2 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>6</td>
											<td>Midterm</td>
											<td>CSE308</td>
											<td>Prof.A</td>
											<td>54</td>
											<td>10/18/2015 2 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>7</td>
											<td>Midterm</td>
											<td>CSE308</td>
											<td>Prof.A</td>
											<td>54</td>
											<td>10/18/2015 2 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>8</td>
											<td>Midterm</td>
											<td>CSE114</td>
											<td>Prof.A</td>
											<td>64</td>
											<td>10/10/2015 1 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>
										<tr>
											<td>9</td>
											<td>Midterm</td>
											<td>CSE114</td>
											<td>Prof.A</td>
											<td>64</td>
											<td>10/10/2015 1 PM</td>
											<td>
												<button type="button" class="btn btn-success  btn-sm">Accept</button>
												<button type="button" class="btn btn-danger  btn-sm">Decline</button>
											</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>
					<ul class="pagination" id="myPager">

					</ul>

				</div>



				<!-- /.row -->




				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->
		</div>


		<div id="page-wrapper2"></div>



	</div>
	<!-- /#page-wrapper -->


	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/table.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>

</body>

</html>
