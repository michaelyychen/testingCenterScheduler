<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navigationBar.jsp"></jsp:include>
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
						<h1 class="page-header">Attendance</h1>
					</div>
				</div>
				<!-- /.row -->


				<!-- Search box Start -->

				<!-- Search box End -->




				<!-- /.row -->

				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<form>
							<div class="well carousel-search hidden-sm">
								<div class="btn-group">
									<a class="btn btn-default dropdown-toggle btn-select"
										data-toggle="dropdown" href="#">Select an Exam <span
										class="caret"></span></a>
									<ul class="dropdown-menu">
										<li><a href="#">CSE110 Midterm F13</a></li>
										<li><a href="#">CSE114 Final F13</a></li>
										<li><a href="#">CSE160 Final F13</a></li>
										<li><a href="#">CSE114 Final S14</a></li>
										<li><a href="#">CSE210 Midterm F14</a></li>
									</ul>
								</div>


							</div>
						</form>
						<div class="panel panel-default">

							<div class="table-responsive">
								<table class="table table-hover table-striped">
									<thead>
										<tr>
											<th>#</th>
											<th>Student</th>
											<th>Seat</th>
											<th>Time</th>
											<th>Attended</th>
										</tr>
									</thead>
									<tbody id="myTable3">
										<tr>
											<th>1</th>
											<td>Student A</td>
											<td>43</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>2</th>
											<td>Student B</td>
											<td>44</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>3</th>
											<td>Student C</td>
											<td>46</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>4</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>5</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>6</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>7</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>8</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>9</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>10</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>11</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>
										<tr>
											<th>12</th>
											<td>Student D</td>
											<td>65</td>
											<td>10/10/2015</td>
											<td>Yes</td>
										</tr>

									</tbody>
								</table>
							</div>
						</div>
					</div>


					<ul class="pagination" id="myPager3">

					</ul>
				</div>



				<!-- /.row -->


				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->
		</div>
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
