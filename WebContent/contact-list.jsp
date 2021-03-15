<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
<link rel="stylesheet" type="text/css" href="ministyle.css">
</head>
<body>

	<form method = "post" action = "navigationServlet">
		<table>
			<c:forEach items="${requestScope.allPersons}" var="currentperson"> 
				<tr>
				<td><input type="radio" name="id" value="${currentperson.personID}"></td> 
				<td>${currentperson.firstName}</td>
				<td>${currentperson.lastName}</td>
				<td>${currentperson.dateOfBirth}</td>
				</tr>
			</c:forEach> 
		</table>
		<input type = "submit" value = "edit" name="doThisToPerson"> 
		<input type = "submit" value = "delete" name="doThisToPerson"> 
		<input type="submit" value = "add" name = "doThisToPerson">
	</form>

</body>
</html>