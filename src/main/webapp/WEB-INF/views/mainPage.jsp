<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

        <div class="header">
               <div>
                   <img class="foto-size-chat radius" src="/resources/image/3.png"/>
                   <p id="m-top-8" >Be always on connection with the "Always near you" application!</p>
       		       <form class="form-wrapper" action="/search">
                        <input type="submit" value="go" id="search-submit">
                        <input id="search" name="search" type="text" onkeyup="searchValidator()"
                        placeholder="${user.name} ${user.surname}" required="">
       			   </form>
       			</div>
       	</div>

        <div>
            <div class=" w-25 left-box  float-l">
                <div id="User-info">
                    <p class="text-align">My Account</p>
                    <img class="user-foto radius-50"  src="${user.avatar}" alt="">
                    <p id="user_name_surname">${user.name} ${user.surname}</p>
                </div>

                <div class="clearfix">
                   <p class="text-align m-top-40 border-top">All users  - Friends online</p>
                   <ul id="userlist"> <!-- Built by JS -->

                        <c:forEach items="${friends}" var="us">
                           <li>
                                <input id="user-id" type="hidden" name="user-id" value="${us.id}">
                                <a href="user-${us.id}"><img class="friend-foto radius"  src="${us.avatar}" alt="">${us.name} ${us.surname}</a>
                           </li>
                        </c:forEach>
                        <p><h4 id="requextStr">Request to be friends: </h4></p>

                       <c:forEach items="${friendof}" var="usOf">
                            <form action="/friendRequest">
                                  <li class="clearfix pddVSborder">
                                        <img class="friend-foto radius clearfix"
                                        src="${usOf.avatar}" alt="">${usOf.name} ${usOf.surname}
                                        <input id="friendof-id" type="hidden" name="friendof-id" value="${usOf.id}">
                                  <div class="clearfix marginVSheigth">
                                    <button class="requestAnsw"  type='submit' name="addToFriend"  value="AddToFriend">Add</button>
                                    <button class="requestAnsw"  type='submit' name="deleteRequest" value="DeleteRequest">Delete request</button></div>
                                  </li>
                            </form>
                       </c:forEach>

                    </ul>
                </div>
            </div>

            <div class="w-50 center-box  float-l">Room name: ${room.name}
                <div id="chat_box " class="body-box">
                    <div id="chat">    <!-- Built by JS --> </div>
                    <div id="chatControls">
                         <form action="/sendMessage" method="post">
                            <input id="room-id" type="hidden" name="room-id" value="${room.id}">

                            <textarea id="messagesTextArea" rows="10" cols="45"></textarea><br><br>
                            <input id="textMessage" type="text" name="textMessage" placeholder="Write your message">
                            <button id="send" value="send" onclick="sendMessage()">Send</button>
                         </form>
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
            </div>
       </div>
        <div class="pidval text-align clearfix">
            <br>
            <br>
            <p> The project was created with support by Okten Web University</p>
        </div>

        <script type="text/javascript" src="/js/search.js"></script>
        <script type="text/javascript" src="/js/chatJS.js"></script>
</body>
</html>
