<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navigationBar.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<body>

	<div class="col-lg-11" id="wrapper">

		<!-- Navigation -->



		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Import Data</h1>

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
									<i class="fa fa-bar-chart-o fa-fw"></i>
								</h2>
							</div>

							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-2 control-label">File:</label>
									<div class="col-sm-6">
										<input type="file" name="img"> <br> <input
											type="submit">


									</div>

								</div>
							</form>

						</div>
					</div>



					<!-- /.row -->


					<!-- /.container-fluid -->
				</div>
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="${pageContext.request.contextPath}/js/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

		<!-- Morris Charts JavaScript -->
		<script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>
</body>

</head>
</html>