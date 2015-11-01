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

<link rel="stylesheet"
	href="https://cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#adhocExam {
	display: none;
}
</style>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->


		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Edit Testing Center Information</h1>
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
									<span class="glyphicon glyphicon-menu-hamburger"
										aria-hidden="true"></span>
								</h2>
							</div>
							<div class="container">
								<h2>Center Detail</h2>
								<form class="form-horizontal" role="form" id="courseExam">
									<div class="form-group">
										<label class="col-sm-2 control-label">Number of Seats</label>
										<div class="col-sm-6">
											<input class="form-control" type="text"
												placeholder="Enter Number ofSeats">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Number of
											Reserved Seats</label>
										<div class="col-sm-6">
											<input class="form-control" type="text"
												placeholder="Enter Number of Set-aside Seats...">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Operating
											Hours</label>

										<div class="col-sm-3">
											<label>From: </label>
											<div class="input-group date" id="datetimepicker1">
												<input class="form-control" id="startTime" type="text"
													placeholder="Select a Start Time..."> <span
													class="input-group-addon"> <span
													class="fa fa-clock-o"></span>
												</span>
											</div>
										</div>
										<div class="col-sm-3">
											<label>To: </label>
											<div class="input-group date" id="datetimepicker2">
												<input class="form-control" id="endTime" type="text"
													placeholder="Select an End Time..."> <span
													class="input-group-addon"> <span
													class="fa fa-clock-o"></span>
												</span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Close
											Dates</label>
										<div class="col-sm-3">
											<label>From: </label> <input class="form-control"
												id="startDate" type="text"
												placeholder="Select a Start Time..."> <span
												class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>

										</div>

										<div class="col-sm-3">
											<label>To: </label> <input class="form-control" id="endDate"
												type="text" placeholder="Select an End Time..."> <span
												class="input-group-addon"> <span
												class="fa fa-clock-o"></span>
											</span>
										</div>

									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label"> Gap Time</label>




										<div class="form-group">
											<div class="col-sm-6">
												<div class="input-group date" id="datetimepicker1">
													<input type="text" class="form-control"
														placeholder="Select the Range of Gap Time..." /> <span
														class="input-group-addon"> <span
														class="fa fa-clock-o"></span>
													</span>
												</div>
											</div>

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label"> Reminder
											Interval</label>




										<div class="form-group">
											<div class="col-sm-6">
												<div class="input-group date">
													<input type="text" class="form-control"
														placeholder="Select Reminder Interval... " /> <span
														class="input-group-addon"> <span
														class="fa fa-clock-o"></span>
													</span>
												</div>
											</div>

										</div>
									</div>

								</form>


							</div>
						</div>
					</div>
				</div>



				<!-- /.row -->

				<div class="row">


					<a href="${pageContext.request.contextPath}/feedback_sucess.html" target="mainarea">
						<button id="request" type="button" class="btn btn-primary">Submit
							Request</button>
					</a>
					<!-- /.row -->

				</div>
				<!-- /.container-fluid -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Morris Charts JavaScript -->

<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script src="${pageContext.request.contextPath}/js/en-gb.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/collapse.js"></script>
<script src="${pageContext.request.contextPath}/js/transition.js"></script>

<script type="text/javascript">
           $(function () {

				$('#datetimepicker1').datetimepicker({
         			 
				format: 'MM/DD/YYYY LT',   
                sideBySide: true,
				disabledHours: [0, 1, 2, 3, 4, 5, 6, 7, 23, 24]

					  
					 
                });
					
            });
        </script>

<script>



    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>




</html>
