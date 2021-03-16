<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>House List</title>
<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<h1>House List</h1>

	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items="${requestScope.allHouses}" var="currenthouse"> 
				<tr>
				<td><input type="radio" name="id" value="${currenthouse.houseID}"></td> 
				<td>${currenthouse.price}</td>
				<td>${currenthouse.yearOfCreation}</td>
				<td>${currenthouse.address}</td>
				</tr>
			</c:forEach> 
		</table>
		<input type = "submit" value = "edit" name="doThisToHouse"> 
		<input type = "submit" value = "delete" name="doThisToHouse"> 
		<input type = "submit" value = "add" name = "doThisToHouse">
	</form>

</body>
</html>