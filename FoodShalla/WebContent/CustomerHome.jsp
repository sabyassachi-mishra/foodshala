<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Foodshala</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<div class="text-center">
<h1>Foodshala</h1>
</div>
<div class="container-fluid bg-dark">
<div class="container bg-light">
<table class="table table-striped table-light">
<tr>
<th>Restaurant</th>
<th>Dish</th>
<th>Type</th>
<th>Price</th>
<th>Place Order</th>
</tr>
<c:forEach var="temp" items="${menulist}" >
<tr>
<td>${temp.rname}</td>
<td>${temp.name}</td>
<td>${temp.type}</td>
<td>${temp.price}</td>
<td><button class="btn btn-info btn-lg" type="submit" >Order</button></td>
</tr>
</c:forEach>
</table>
<c:url var="link" value="logout">
</c:url>
<div class="text-right">
<a href="${link}" >LOGOUT</a>
</div>
</div>
</div>
</body>
