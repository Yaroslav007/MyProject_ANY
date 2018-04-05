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
	            <form id="myForm" action="/save" class="form-horizontal" method="post" enctype="multipart/form-data">
                    <fieldset>
                        <!-- Form Name -->
                        <legend><strong><h2>Registration</h2></strong></legend>
                        <!-- Text input-->
                        <div  class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="Name">Name</label>
                          <div class="col-md-5">
                            <input id="name" name="name" type="text" placeholder="name" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label">Surname</label>
                          <div class="col-md-5">
                            <input i name="surname" type="text" placeholder="surname" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="birthday">Birthday</label>
                          <div class="col-md-5">
                            <input id="birthday" name="birthday" type="text"
                            placeholder="yyyy-mm-dd" class="form-control input-md" required="" onkeyup="checkData()">
                          </div>
                        </div>
                        <!-- Password input-->
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="passwordinput">Password</label>
                          <div class="col-md-5">
                            <input id="passwordinput" name="password" type="password" placeholder="your password" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Password input-->
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="confirm_password">Confirm Password</label>
                          <div class="col-md-5">
                            <input id="confirm_password" name="confirm_password"
                                            type="password" placeholder="Re-type password" class="form-control input-md" required=""
                                            onkeyup="checkPass()">
                             <span id="confirmMessage" class="confirmMessage"></span>
                          </div>
                        </div>
                       <div class="form-group pd-bottom-40">
                         <label class="col-md-4 control-label" for="gender">Gender</label>
                         <div class="col-md-5">
                           <select id="gender" name="gender"  type="text" class="form-control">
                             <option value="man">man</option>
                             <option value="woman">woman</option>
                           </select>
                         </div>
                       </div>
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="address">Address</label>
                          <div class="col-md-5">
                            <input name="address" type="text" placeholder="address" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Select Basic -->
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label">Country</label>
                          <div class="col-md-5">
                            <input name="country" type="text" placeholder="country" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label">Mobile Number</label>
                          <div class="col-md-5">
                            <input id="phone" name="phone" type="text" placeholder="(+38) XXX XXX XXXX"
                             onkeyup="phonenumber()" class="form-control input-md" required="">
                          </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group pd-bottom-40">
                          <label class="col-md-4 control-label" for="emailId">Email</label>
                          <div class="col-md-5">
                            <input id="email" name="email" type="text"  onkeyup="checkEmail()" placeholder="user@domain.com" class="form-control input-md" required="">
                          </div>
                        </div>
                        <div class="form-group pd-bottom-40">
                            <label class="headerfoto col-md-4 control-label">Profile Photo:</label>
                            <div class="col-md-6">
                                 <input id="image" type="file" name="avatar" placeholder="Photo" required="" capture>
                             </div>
                        </div>
                        <!-- Button -->
                        <div class="form-group pd-bottom-40">
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
     <script>
       function checkPass(){
           //Store the password field objects into variables ...
           var pass1 = document.getElementById('passwordinput');
           var pass2 = document.getElementById('confirm_password');
           var button = document.getElementById('submit');


           //Store the Confimation Message Object ...
           var message = document.getElementById('confirmMessage');

           //Set the colors we will be using ...
           var goodColor = "#66cc66";
           var badColor = "#ff6666";

           //Compare the values in the password field
           //and the confirmation field
           if(pass1.value == pass2.value){
               //The passwords match.
               //Set the color to the good color and inform
               //the user that they have entered the correct password
               pass2.style.backgroundColor = goodColor;
               message.style.color = goodColor;
               message.innerHTML = "Passwords Match!"
               button.disabled = false;
           }else{
               //The passwords do not match.
               //Set the color to the bad color and
               //notify the user.
               pass2.style.backgroundColor = badColor;
               message.style.color = badColor;
               message.innerHTML = "Passwords Do Not Match!"
               button.disabled = true;
           }
       }

       function checkEmail() {
           var email = document.getElementById('email');
           var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
           var button = document.getElementById('submit');
           if (!filter.test(email.value)) {
               email.focus;
               email.style.backgroundColor = "#ff6666";
               button.disabled = true;
               return false;
           }else{
               email.style.backgroundColor = "#66cc66";
               button.disabled = false;
               return true;
           }
       }


       function phonenumber() {
         var phone = document.getElementById('phone');
         var filter = /^\+?([0-9]{3})\)?[ ]?([0-9]{3})[ ]?([0-9]{4})$/;
         var button = document.getElementById('submit');
         if(!filter.test(phone.value)) {
               phone.style.backgroundColor = "#ff6666";
               button.disabled = true;
               return false;
         }else {
               phone.style.backgroundColor = "#66cc66";
               button.disabled = false;
               return true;
         }
       }

       function checkData() {
           var birthday = document.getElementById('birthday');
           var filter = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))$/;
           var button = document.getElementById('submit');
           if (!filter.test(birthday.value)) {
               birthday.focus;
               birthday.style.backgroundColor = "#ff6666";
               button.disabled = true;
               return false;
           }else{
                birthday.style.backgroundColor = "#66cc66";
                button.disabled = false;
                return true;
           }

       }
     </script>
</body>
</html>
