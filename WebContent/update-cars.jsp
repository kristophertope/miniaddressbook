<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Cars</title>
</head>
<body>

	<h1>Update Cars</h1>
	
	<form action = "addCarServlet" method="post"> 
		Make: <input type ="text" name = "make"> <br>
		Model: <input type = "text" name = "model"><br>
		Price: <input type = "text" name = "price"><br>
		Model Year: <input type = "text" name = "yearOfCreation"><br>
		<input type = "submit" value="Add Car"> 
	</form>

</body>
</html>