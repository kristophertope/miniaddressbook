<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Contact</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>Edit Contact</h1>

	<form action = "editPersonServlet" method="post">
		First Name: <input type ="text" name = "FirstName" value= "${personToEdit.firstName}">
		Last Name: <input type = "text" name = "LastName" value= "${personToEdit.lastName}"> 
		Date of Birth: <input type = "text" name = "DateOfBirth" value= "${personToEdit.dateOfBirth}">
		<input type = "hidden" name = "id" value="${personToEdit.personID}">
		<input type = "submit" value="Save Edited Item">
	</form>

	<a href = "editHouseServlet">Edit Houses</a>
	<a href = "editCarServlet">Edit Cars</a>

</body>
</html>