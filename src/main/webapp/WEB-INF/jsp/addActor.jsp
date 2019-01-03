<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Actor</title>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
</head>
<body>
	<center>
	<h2>Add Actor</h2>
	<form action="saveActor" method="post">
		<table>
		<tr><td>Actor Name </td><td><input type="text" name="name"/></td></tr>
		<tr><td>Actor Age</td><td><input type="text" name="age"/></td></tr>
		<tr><td>Actor Gender</td><td><input type="text" name="gender"/></td></tr>
		<tr><td><input type="submit" value="Add Actor"/></td></tr>
		</table>
	</form>
	</center>
</body>
</html>