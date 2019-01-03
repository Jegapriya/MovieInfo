<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Genre</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>All Genre</h2>
	<form>
		<table>
			<th>Genre Id </th>
			<th>Genre Name</th>
			<c:forEach items="${genre}" var="genre">
			<tr><td>${genre.id}</td>
			<td>${genre.name}</td>
			</c:forEach>
		</table>
	</form>
	</center>
</body>
</html>