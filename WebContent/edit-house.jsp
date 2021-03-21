<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit House</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>Edit House</h1>

	<form action = "editHouseServlet" method="post">
		Price: <input type ="text" name = "Price" value= "${houseToEdit.price}">
		Year of Creation: <input type = "text" name = "YearOfCreation" value= "${houseToEdit.yearOfCreation}"> 
		Address: <input type = "text" name = "Address" value= "${houseToEdit.address}">
		<input type = "hidden" name = "id" value="${houseToEdit.houseID}">
		<input type = "submit" value="Save Edited Item">
	</form>

</body>
</html>