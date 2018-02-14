<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
	Greeting : ${greeting}
	<form action="/save" method="post">
	    <input type="text" name="name" placeholder="name">
	    <input type="text" name="surname" placeholder="surname">
	    <input type="submit" value="save">
	</form>
</body>
</html>