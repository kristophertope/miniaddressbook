<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Update Cars</title>
	<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>Update Cars</h1>

	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items="${requestScope.allCars}" var="currentcar"> 
				<tr>
					<td><input type="radio" name="id" value="${currentcar.carID}"></td> 
					<td>${currentcar.make}</td>
					<td>${currentcar.model}</td>
					<td>${currentcar.yearOfCreation}</td>
										<td>${currentcar.price}</td>
				</tr>
			</c:forEach> 
		</table>
		<input type = "submit" value = "edit" name="doThisToCar"> 
		<input type = "submit" value = "delete" name="doThisToCar"> 
		<input type="submit" value = "add" name = "doThisToCar">
	</form>

	<a href = "/index.html">Back to Home</a>

</body>
</html>