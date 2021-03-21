<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add House</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>
	<h1>Add House</h1>

	<form action = "addHouseServlet" method="post"> 
		Price: <input type ="text" name = "Price"> <br>
		Year Built: <input type = "text" name = "YearOfCreation"><br>
		Address: <input type = "text" name = "Address"><br>
		<input type = "hidden" name = "id" value = "${idPerson}">
		<input type = "submit" value="Add House"> 
	</form>

</body>
</html>