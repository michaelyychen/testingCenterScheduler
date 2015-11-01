<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>TCS Login Page</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet" media="screen">
</style>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
           
          <form class="form-signin" method="post"  action="${pageContext.request.contextPath}/control/user.do?method=login">
                <span id="reauth-email" class="reauth-email"></span>
            <input type="email" id="username" name="username" class="form-control" placeholder="User Name" required autofocus>
                <input type="password" id="inputPassword" name="password"  class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember Me
                    </label>
            </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
          </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot your password?
          </a>
        </div><!-- /card-container -->
</div><!-- /container -->
</html>
