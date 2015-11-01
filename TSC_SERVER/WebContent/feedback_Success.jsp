<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <style>
	#title{
	text-align: center;
		
	}	
	body,#wrapper{
		
	margin: 50px;	
		
		}
    </style>
    
    </head>
<body>

    <div class="col-lg-11" id="wrapper">

        <!-- Navigation -->
   
 		

      	<div id="page-wrapper">

        <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                  <div class="col-lg-12" id = "title">
                        <h1 class="page-header" >
                            Your Request Has Been Sucessfully Processed 
                        </h1>
                     <a href="home.html" target="mainarea" >   <button type="button" class="btn btn-success btn-lg" >Home</button></a>
                        
                  </div>
                </div>
                <!-- /.row -->
                    
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
    <script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>
</div>
</body>


</html>