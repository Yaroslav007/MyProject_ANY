<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="/css/main.css">
</head>

<body id="body_id">
	<div>

    <div class="header">
        <div class="text-align">
            <img class="foto-size-chat radius" src="/resources/image/3.png"/>
            <span id="m-top-8" >Welcome to chat: "Always near you"!</span>
        </div>
    </div>

     <div id="m-left-0" class="row background-foto ">
        <div id="devolop-block" class="col-xs-12 col-md-8 text-align-center"><h1>Always near you</h1>
            <p class="big-text">Chat is designed for real-time, unstructured <br>
                conversations with users who<br>
                are signed on to the site at the same time.</p>
        </div>
        <div id="panelka" class="col-xs-6 col-md-3">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <form method="POST" action="logIn" role="form">
                        <div class="form-group">
                            <h2>Sign in</h2>
                        </div>
                        <div class="form-group">
                            <strong>Email</strong>
                            <input id="signinEmail" name="signinEmail" type="text" maxlength="50" class="form-control">
                        </div>
                        <div class="form-group">
                            <strong>Password</strong>
                            <input id="signinPassword" name="signinPassword" type="password" maxlength="25" class="form-control">
                        </div>
                        <div class="form-group" style="padding-top: 12px;">
                            <button id="signinSubmit" type="submit" class="btn btn-success btn-block">Sign in</button>
                        </div>
                        <div class="form-group divider">
                            <hr class="left"><small>New to site?</small><hr class="right">
                        </div>
                            <p class="form-group"><a href="new" class="btn btn-info btn-block">Create new account</a></p>
                            <p class="form-group text-align-center">By clicking <a href="new">"Create new account"</a> , you agree to our terms
                            of service and privacy privacy policy.We’ll occasionally send you account related emails.</p>
                    </form>
                </div>
            </div>
        </div>
    </div>

   <div class="pidval text-align clearfix">

    <br>
    <strong> The project was created with support by Okten Web University</strong>
	</div>
	</div>


</body>
</html>