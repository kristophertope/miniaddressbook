<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Car</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>Edit Car</h1>

	<form action = "editPersonServlet" method="post">
		First Name: <input type ="text" name = "FirstName" value= "${personToEdit.firstName}">
		Last Name: <input type = "text" name = "LastName" value= "${personToEdit.lastName}"> 
		Date of Birth: <input type = "text" name = "DateOfBirth" value= "${personToEdit.dateOfBirth}">
		<input type = "hidden" name = "id" value="${personToEdit.personID}">
		<input type = "submit" value="Save Edited Item">
	</form>

</body>
</html>