<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select All</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>All Actors</h2>
	<form>
		<table border=1>
			<th>Actor Id </th>
			<th>Actor Name</th>
			<th>Actor Age</th>
			<th>Actor Gender</th>
			<c:forEach items="${actors}" var="actors">
			<tr><td>${actors.id}</td>
			<td>${actors.name}</td>
			<td>${actors.age}</td>
			<td>${actors.gender}</td></tr>
			</c:forEach>
		</table>
	</form>
	</center>
</body>
</html>