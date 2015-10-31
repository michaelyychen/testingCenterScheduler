<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<<jsp:include page="menu.jsp"></jsp:include>

  <div class="col-lg-11" id="wrapper">

        <!-- Navigation -->
   
 		

      	<div id="page-wrapper">

        <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                  <div class="col-lg-12">
                        <h1 class="page-header">
                            Welcome Back! 
                        </h1>

                  </div>
                </div>
                <!-- /.row -->

              <div class="row"> </div>
                <!-- /.row -->

                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                      <div class="panel panel-default">
                            <div class="panel-heading">
                              <h2 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i> Your Upcoming Exams</h2>
                            </div>
<div class="table-responsive">
                <table class="table table-hover table-striped">
                                <thead>
                                    <tr>
                                    	<th>#</th>
                                        <th>Exam</th>
                                        <th>Course</th>
                                        <th>Professor</th>
                                        <th>Date</th>
                                    </tr>
                                </thead>
                                <tbody id="myTable">
                                    <tr>
                                   		 <td>1</td>
                                        <td>Midterm</td>
                                        <td>CSE114</td>
                                        <td>Prof.A</td>
                                        <td>10/10/2015</td>
                                    </tr>
                                     <tr>
                                     <td>2</td>
                                        <td>Final</td>
                                        <td>CSE214</td>
                                        <td>Prof.A</td>
                                        <td>10/15/2015</td>
                                    </tr>
                                    <tr>
                                    <td>3</td>
                                        <td>Midterm</td>
                                        <td>CSE308</td>
                                        <td>Prof.A</td>
                                        <td>10/18/2015</td>
                                    </tr>
                                                                        <tr>
                                    <td>4</td>
                                        <td>Midterm</td>
                                        <td>CSE308</td>
                                        <td>Prof.A</td>
                                        <td>10/18/2015</td>
                                    </tr>
                                                                        <tr>
                                    <td>5</td>
                                        <td>Midterm</td>
                                        <td>CSE308</td>
                                        <td>Prof.A</td>
                                        <td>10/18/2015</td>
                                    </tr>
                                                                        <tr>
                                    <td>6</td>
                                        <td>Midterm</td>
                                        <td>CSE308</td>
                                        <td>Prof.A</td>
                                        <td>10/18/2015</td>
                                    </tr>
                        
                                </tbody>
              </table>
                        </div>
                    </div>
                                           <ul class="pagination" id = "myPager">
                         
                        </ul>
                </div>
              </div>
                   
              
           
<!-- /.row -->

            <!-- /.container-fluid -->
</div>
        </div>
        <!-- /#page-wrapper -->

    </div>

</body>
</html>