<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Genre List</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>Genre Selection</h2>
	<form action="selectOnGenreList" method="post">
	<table>
	<tr><td>Genre Name <input type="text" name="genre_name"/></td></tr>
	<tr><td><input type="submit" value="Select on genre"/></td></tr>
	</table>
	</form>
	</center>
</body>
</html>