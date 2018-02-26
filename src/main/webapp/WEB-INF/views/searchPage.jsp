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
<body id="body_color">
    <div class="header">
        <div>
            <img class="foto-size-chat radius" src="/resources/image/3.png"/>
            <p id="m-top-8" >Be always in connection with the "Always near you" application!</p>

			<form class="form-wrapper">
				<input type="submit" value="go" id="search-submit">
				<input type="text" id="search" placeholder="Search for..." required="">
			</form>
		</div>
    </div>

	 <div class="w-25 float-l bg-grey">
	 </div>
	 <div class="w-50 float-l">
        <div class="clearfix people-found bg-color-foundPeople">
            <img class="people-foto " src="Images/people2.jpg"/>
            <p id="m-top-8" > Found people</p>
        </div>

        <ul class="clearfix" id="foundUs"> <!-- Built by JS -->

           <c:forEach items="${foundUsers}" var="us">
               <li class="clearfix"><img class="found-user-foto float-l"  src="${user.avatar}" alt=""><br>
                    <div class="float-l">
                        <p id="mtop-42">${user.name}, ${user.surname} </p>
                        <p>${user.address}, ${user.country}</p>
                    </div>
                    <button id="addToFriend" class="hoverbutton" style="vertical-align:middle"><span>Add to Friend </span></button>
                    <p class="p-border"></p>
               </li>
            </c:forEach>
        </ul>
	  </div>
	 <div class="w-25 float-l bg-grey">
	 </div>
</body>
</html>

