<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Car</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>
	<h1>Add Car</h1>

	<form action = "addCarServlet" method="post"> 
		Make: <input type ="text" name = "Make"> <br>
		Model: <input type = "text" name = "Model"><br>
		Price: <input type = "text" name = "Price"><br>
		Model Year: <input type = "text" name = "YearOfCreation"><br>
		<input type = "hidden" name = "id" value = "${idPerson}">
		<input type = "submit" value="Add Car"> 
	</form>
	
</body>
</html>