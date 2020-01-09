<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello guy</title>
</head>
<body>
	<%-- First page on jsp --%>
	<% String message = "welcome to agenda system with FJ-21!"; %>
	<% out.println(message); %>
	<br />
	<% String developed = "Developed by Vitor Santos"; %>
	<%= developed %>
	<br/>
	<% System.out.println("All executed!"); %>
</body>
</html>