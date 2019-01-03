<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Highest Grossing Movie</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>Movie Info</h2>
	<table>
		<tr><td>Movie Id : ${movie.id}</td></tr>
		<tr><td>Movie Name : ${movie.name}</td></tr>
		<tr><td>Boxoffice : ${movie.boxoffice}</td></tr>
		<tr><td>Actor : ${movie.actors.name}</td>
		<tr><td>Type : ${movie.genere.name}</td>
		</tr>
	</table>
	</center>
</body>
</html>