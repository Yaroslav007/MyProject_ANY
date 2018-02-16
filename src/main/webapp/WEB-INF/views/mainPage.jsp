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
            <span id="m-top-8" >Be always in connection with the "Always near you" application!</span>
        </div>
    </div>


    <div>
        <div class=" w-25 left-box  float-l">
            <div id="User-info">
              	<p class="text-align">My Account</p>
				<img class="user-foto radius" src="/resources/image/3.png"/> <-- <img src="${user.avatar}" alt="">-->
				<p id="user_name_surname">Name Surname</p>
            </div>
            <div id="all-users">
               <p class="text-align">All users</p>

            </div>
        </div>

        <div class="w-50 center-box  float-l">center-box
            <div id="chat_box " class="body-box">
                <div id="chat">    <!-- Built by JS --> </div>
                <div id="chatControls">
                    <input id="message" placeholder="Write your message">
                    <button id="send">Send</button>
                </div>
            </div>
        </div>

        <div class="w-25 right-box  float-l">
			<div class="m-top-10 m-left-20">
				<span class="margin">Create the video call</span>
				<button id="videoCall"  class="float-left button2 ">Video call</button>
			</div>
			<div class="m-top-20 m-left-20">
				<span class="margin">Add new Friend</span>
				<button id="videoCall" class="button2 "> Add</button>
			</div>

			<div class="m-top-20 m-left-20">
				<span class="margin">Remove freind</span>
				<button id="videoCall" class="button2"> Remove</button>
			</div>
			<div class="m-top-20 m-left-20">
				<span class="margin">Delete all message from room</span>
				<button id="videoCall" class="button2"> Delete</button>
			</div>

			<div class="clearfix">
				<p class="text-align m-top-40 border-top">Friends online</p>
				<ul id="userlist"> <!-- Built by JS --> </ul>
            </div>

        </div>
   </div>

   <div class="pidval text-align clearfix">
		<br>
		<br>
		<p> The project was created with support by Okten Web University</p>
	</div>
	</div>

</body>
</html>