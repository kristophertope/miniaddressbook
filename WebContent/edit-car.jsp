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

	<form action = "editCarServlet" method="post">
		Make: <input type = "text" name = "Make" value= "${carToEdit.make}">
		Model: <input type = "text" name = "Model" value= "${carToEdit.model}">
		Price: <input type ="text" name = "Price" value= "${carToEdit.price}">
		Model Year: <input type = "text" name = "YearOfCreation" value= "${carToEdit.yearOfCreation}"> 
		<input type = "hidden" name = "id" value="${carToEdit.carID}">
		<input type = "submit" value="Save Edited Item">
	</form>

</body>
</html>