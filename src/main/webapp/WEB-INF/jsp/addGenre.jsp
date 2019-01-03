<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Genre</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>Add Genre</h2>
	<form action="saveGenre" method="post">
		<table>
		<tr><td>Genre Id </td><td><input type="text" name="id"/></td></tr>
		<tr><td>Genre Name </td><td><input type="text" name="name"/></td></tr>
		<tr><td><input type="submit" value="Add Genre"/></td></tr>
		</table>
	</form>
	</center>
</body>
</html>