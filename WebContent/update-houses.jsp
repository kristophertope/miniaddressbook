<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Houses</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>Update Cars</h1>

	<form action = "addHouseServlet" method="post"> 
		Price: <input type ="text" name = "price"> <br>
		Year Built: <input type = "text" name = "yearOfCreation"><br>
		Address: <input type = "text" name = "address"><br>
		<input type = "submit" value="Add House"> 
	</form>

</body>
</html>