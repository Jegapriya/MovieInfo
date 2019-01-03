<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Box Office</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>Update Box Office</h2>
	<form action="updateBoxoffice" method="post">
		<table>
		<tr><td>Movie Id </td><td><input type="text" name="id"/></td></tr>
		<tr><td>Boxoffice </td><td><input type="text" name="boxoffice"/></td></tr>
		<tr><td><input type="submit" value="Update BoxOffice"/></td></tr>
		</table>
	</form>
	</center>
</body>
</html>