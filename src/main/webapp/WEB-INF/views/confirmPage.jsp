<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="/css/main.css">
</head>

<body class="background-foto-confirm">
    <div>
	    <div class="container">
	        <div class="row">
		        <form action="/confirm" method="post" class="form-horizontal" enctype="multipart/form-data">
                    <fieldset>
                        <!-- Form Name -->
                        <legend><strong id="text-color"><h2>2-Step Verification.
                            So we can make sure that this is really you.
                            We sent a verification code to your mail.</h2></strong>
                        </legend>
                        <!-- Text input-->
                        <div id="text-color" class="form-group m-top-40">
                          <label class="col-md-4 control-label" for="confirm">Always near you</label>
                          <div class="col-md-5">
                            <input id="confirm" name="confirm" type="text" placeholder="Write code from email" class="form-control input-md" required="">
                          </div>
                        </div
                        <!-- Button -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="submit"></label>
                          <div class="col-md-4 m-top-20">
                            <button id="submit" name="submit" class="btn btn-success" value="confirm">Submit</button>
                          </div>
                        </div>
                    </fieldset>
		        </form>
		    </div>
	    </div>
    </div>
</div>
</body>
</html>