<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>
</head>
<style>
	body {
    	background-color: #00FFBB;
	}
</style>
<body>
	<center>
	<h2>Add Movie</h2>
	<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "movieinfo";
String userId = "root";
String password = "Welcome123";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM genre";

resultSet = statement.executeQuery(sql);
%>

	<form action="saveMovie" method="post">
		<table>
		<tr><td>Movie Name</td><td><input name="name"/></td></tr>
		<tr><td>Movie Type</td><td><input name="type"/></td></tr>
		<tr><td>Box Office</td><td><input name="boxoffice"/></td></tr>
		<tr><td>Genre List</td><td><select name="genre_id">
		<%
		while(resultSet.next()){
		%>
		<option value=<%=resultSet.getString("id") %>><%=resultSet.getString("name") %></option>
		<% 
		}

		sql ="SELECT * FROM actors";

		resultSet = statement.executeQuery(sql);
		%></select>
		<tr><td>Actors List</td><td><select name="actors_id">
		<% while(resultSet.next()){%>
		<option value=<%=resultSet.getString("id") %>><%=resultSet.getString("name") %></option>
		<% 
		}
		%></select>
		</tr>
		
		<tr><td><input type="submit" value="Add Movie" /></td></tr>

<%
} catch (Exception e) {
e.printStackTrace();
}
%>
		</table>
		</center>
	</form>
</body>
</html>