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






				<!-- /.row -->

				<div class="row">
					<!-- /.row -->

				</div>
				<!-- /.container-fluid -->
			</div>


			<div id="page-wrapper2">

				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="row">
						<div class="col-lg-12">
							<h1 class="page-header">View Request</h1>

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
												<th>Term</th>
												<th>#Should Take</th>
												<th># Taken</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody id="myTable2">
											<tr>
												<td>1</td>
												<td>CSE114 Midterm</td>
												<td>Fall 14</td>
												<td>30</td>
												<td>29</td>
												<td>Approved</td>
												<td>
													<button type="button" class="btn btn-warning  btn-sm">Cancel</button>

												</td>
											</tr>
											<tr>
												<td>2</td>
												<td>CSE214 Midterm</td>
												<td>Fall 15</td>
												<td>35</td>
												<td>25</td>
												<td>Pending</td>
												<td>
													<button type="button" class="btn btn-warning  btn-sm">Cancel</button>

												</td>
											</tr>
											<tr>
												<td>3</td>
												<td>CSE219 Final</td>
												<td>Fall 15</td>
												<td>20</td>
												<td>16</td>
												<td>Approved</td>
												<td>
													<button type="button" class="btn btn-warning  btn-sm">Cancel</button>

												</td>
											</tr>
											<tr>
												<td>4</td>
												<td>CSE334 Final</td>
												<td>Fall 15</td>
												<td>30</td>
												<td>29</td>
												<td>Declined</td>
												<td>
													<button type="button" class="btn btn-warning  btn-sm">Cancel</button>

												</td>
											</tr>
											<tr>
												<td>5</td>
												<td>CSE114 Midterm II</td>
												<td>Summer 16</td>
												<td>60</td>
												<td>-</td>
												<td>Approved</td>
												<td>
													<button type="button" class="btn btn-warning  btn-sm">Cancel</button>

												</td>
											</tr>
										</tbody>
									</table>
								</div>

								<ul class="pagination" id="myPager2">

								</ul>

							</div>
						</div>
					</div>



					<!-- /.row -->

					<div class="row">



						<!-- /.row -->

					</div>
					<!-- /.container-fluid -->
				</div>
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
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
