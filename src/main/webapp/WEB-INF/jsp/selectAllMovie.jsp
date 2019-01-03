<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Movies</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>All Movies</h2>
	<form>
		<table border=1>
			<th>Movie Id </th>
			<th>Movie Name</th>
			<th>Boxoffice</th>
			<th>type</th>
			<th>Actor</th>
			<c:forEach items="${movie}" var="movie">
			<tr><td>${movie.id}</td>
			<td>${movie.name}</td>
			<td>${movie.boxoffice}</td>
			<td>${movie.genere.name}</td>
			<td>${movie.actors.name}</td>
			</tr>
			</c:forEach>
		</table>
	</form>
	</center>
</body>
</html>