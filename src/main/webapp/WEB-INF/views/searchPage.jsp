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
    <div id="serchform" class="header">
        <div>
            <img class="foto-size-chat radius" src="/resources/image/3.png"/>
            <p id="m-top-8" >Be always in connection with the "Always near you" application!</p>
                <form class="form-wrapper" action="/search">
                    <input type="submit" value="go" id="search-submit">
                    <input id="search" name="search" type="text" onkeyup="searchValidator()"
                    placeholder="${user.name} ${user.surname}" required="">
                </form>
		</div>
    </div>

	 <div class="w-25 float-l bg-grey">
	 </div>
	 <div class="w-50 float-l">
        <div class="clearfix people-found bg-color-foundPeople">
            <img class="people-foto " src="/resources/image/people2.jpg"/>
            <p id="m-top-8" > Found people</p>
        </div>

        <ul class="clearfix" id="foundUs"> <!-- Built by JS -->

           <c:forEach items="${foundUsers}" var="fu">
               <form action="/sendRequestToFriend">
                   <li class="clearfix"><img class="found-user-foto float-l"  src="${fu.avatar}" alt=""><br>
                        <div class="float-l">
                            <p id="mtop-42">${fu.name}, ${fu.surname} </p>
                            <p>${fu.address}, ${fu.country}</p>
                              <input id="fu-id" type="hidden" name="fu-id" value="${fu.id}">
                        </div>
                        <button id="addToFriend" class="hoverbutton" value="sendArequestToAFriend"
                            tyle="vertical-align:middle"><span>Add to Friend </span></button>
                        <p class="p-border"></p>
                   </li>
               </form>
            </c:forEach>
        </ul>
	  </div>
	 <div class="w-25 float-l bg-grey">
	 </div>
	  <script type="text/javascript" src="/js/search.js"></script>
</body>
</html>

