<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navigationBar.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
						<h1 class="page-header">Check-In</h1>
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
								<h2>Student Information</h2>
								<form class="form-horizontal" role="form" id="courseExam">
									<div class="form-group">
										<label class="col-sm-2 control-label">Name</label>
										<div class="col-sm-6">
											<input class="form-control" type="text"
												placeholder="Enter Name...">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Student ID</label>
										<div class="col-sm-6">
											<input class="form-control" type="text"
												placeholder="Enter Student ID...">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Exam
											Title</label>
										<div class="col-sm-6">
											<input class="form-control" id="examTitleInput" type="text"
												placeholder="Enter Exam Title...">
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Time</label>
										<div class="col-sm-6">

											<div class="input-group date" id="datetimepicker1">
												<input type="text" class="form-control"
													placeholder="Select a Time Slot" /> <span
													class="input-group-addon"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>




										</div>
									</div>








									<div class="form-group">

										<label for="inputPassword" class="col-sm-2 control-label">Seat</label>


										<div class="col-sm-6">
											<form>

												<div class="btn-group">
													<a class="btn btn-default dropdown-toggle btn-select"
														data-toggle="dropdown" href="#">Select a Seat <span
														class="caret"></span></a>
													<ul class="dropdown-menu">
														<li><a href="#">.</a></li>
														<li><a href="#">.</a></li>
														<li><a href="#">.</a></li>
													</ul>


												</div>
											</form>
										</div>

									</div>


								</form>


							</div>
						</div>
					</div>
				</div>



				<!-- /.row -->

				<div class="row">


					<a href="feedback_sucess.html" target="mainarea">
						<button id="request" type="button" class="btn btn-success">Check-In</button>
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
		$(".dropdown-menu li a").click(function(){
		  var selText = $(this).text();
		  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
		});

		 </script>
<!-- Morris Charts JavaScript -->
<script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>




</html>
