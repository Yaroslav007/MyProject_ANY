<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="/css/main.css">
</head>


<body>
    <div class="background-foto-newAc">
        <div class="container">
	        <div class="row">
	            <form action="/save" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <!-- Form Name -->
                        <legend><strong><h2>Registration</h2></strong></legend>
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="Name">Name</label>
                          <div class="col-md-5">
                            <input id="Name" name="name" type="text" placeholder="name" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-md-4 control-label">Surname</label>
                          <div class="col-md-5">
                            <input i name="surname" type="text" placeholder="surname" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group">
                          <label class="col-md-4 control-label">Birthday</label>
                          <div class="col-md-5">
                            <input name="birthday" type="text" placeholder="yyyy-mm-dd" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Password input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="passwordinput">Password</label>
                          <div class="col-md-5">
                            <input id="passwordinput" name="password" type="password" placeholder="your password" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Password input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="confirm_password">Confirm Password</label>
                          <div class="col-md-5">
                            <input id="confirm_password" name="confirm_password"
                                            type="password" placeholder="Re-type password" class="form-control input-md" required=""
                                            onkeyup="checkPass(); return false;">
                             <span id="confirmMessage" class="confirmMessage"></span>
                          </div>
                        </div>
                       <div class="form-group">
                         <label class="col-md-4 control-label" for="gender">Gender</label>
                         <div class="col-md-5">
                           <select id="gender" name="gender"  type="text" class="form-control">
                             <option value="man">man</option>
                             <option value="woman">woman</option>
                           </select>
                         </div>
                       </div>
                        <!-- Textarea -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="address">Address</label>
                          <div class="col-md-4">
                            <textarea class="form-control" id="address" name="address">default text</textarea>
                          </div>
                        </div>
                        <!-- Select Basic -->
                        <div class="form-group">
                          <label class="col-md-4 control-label">Country</label>
                          <div class="col-md-5">
                            <input name="country" type="text" placeholder="country" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label">Mobile Number</label>
                          <div class="col-md-5">
                            <input id="phone" name="phone" type="m" placeholder="Mobile Number" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="emailId">Email</label>
                          <div class="col-md-6">
                            <input id="emailId" name="email" type="text" placeholder="user@domain.com" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group">
                            <label class="headerfoto col-md-4 control-label">Profile Photo:</label>
                            <div class="col-md-6">
                                 <input id="image" type="file" name="avatar" placeholder="Photo" required="" capture>
                             </div>
                        </div>
                        <!-- Button -->
                        <div class="form-group">
                          <label class="col-md-4 control-label" for="submit"></label>
                          <div class="col-md-4">
                            <button id="submit" name="submit"  class="btn btn-success" value="save" >Submit</button>
                          </div>
                        </div>
                    </fieldset>
                </form>
	        </div>
        </div>
    </div>
    <script type="text/javascript" src="/resources/js/script.js"></script>
</body>
</html>