<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodShala</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="text-center">
<h1>FoodShala</h1>
</div>
<hr>
<div class="container-fluid bg-dark ">
<div class="container bg-light">
<div class="row justify-content-center">
<div  class="col-md-5 offset-md-1 ">
<form role="form" method="post" action="CheckUser">
			<h2>Login</h2>
			<div class="form-group">
			<label for="name">UserName</label>
			<input id="name" name="funame" type="text" placeholder="Enter Name" class="form-control" required>
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input id="password" name="fpass" type="password" placeholder="Enter Password" class="form-control" required>
		</div>
		
		<div  class="offset-md-4 ">
		<button class="btn btn-info btn-lg" type="submit">Submit</button>
		</div>
		<hr>
		</form>
		<div  class="offset-md-3 ">
		<a href="RegisterRestaurant.jsp">Restaurant Registration</a>
		<br>
		<a href="RegisterCustomer.jsp">Customer Registration </a>
		</div>
</div>
</div>
</div>
</div>
</body>
</html>