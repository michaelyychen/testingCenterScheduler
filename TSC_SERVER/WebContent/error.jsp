<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
     <link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet" media="screen">
     <script  src="${pageContext.request.contextPath}/js2/jquery-2.1.4.js"></script>
    <script  src="${pageContext.request.contextPath}/js2/tsc.js">
    
    </script>
	 
  </head>

  <body>
   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button onClick="onNext" type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Testing Scheduler Center</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"></li>
              <li></li>
              <li></li>
              <li class="dropdown">
<ul class="dropdown-menu">
              <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <form class="navbar-form pull-right" >
</form>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="hero-unit">
        <h1>Error !</h1>
        <p>
         ${error.message}
		</p>
        <p>&nbsp;</p>
      </div>

      <!-- Example row of columns -->
      
      <hr>

     <footer class="foot_para">
        <p>&copy; Stony Brook University Testing Scheduler Center 2015</p>
      </footer>

    </div> <!-- /container -->
    
  </body>
</html>