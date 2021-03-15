<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Contact</title>
</head>
<body>

	<h1>Edit Contact</h1>

	<form action = "editPersonServlet" method="post">
		First Name: <input type ="text" name = "FirstName" value= "${personToEdit.FirstName}">
		Last Name: <input type = "text" name = "LastName" value= "${personToEdit.LastName}"> 
		Date of Birth: <input type = "text" name = "DateOfBirth" value= "${personToEdit.DateOfBirth}">
		<input type = "hidden" name = "id" value="${personToEdit.PersonID}">
		<input type = "submit" value="Save Edited Item">
	</form>

	<a href = "editHousesServlet">Edit Houses</a>
	<a href = "editCarsServlet">Edit Cars</a>

</body>
</html>