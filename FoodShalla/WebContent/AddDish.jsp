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
<form role="form" method="post" onsubmit="return validate()" action="AddDish">
			<h2>Register</h2>
			<div class="form-group">
			<label for="name">Dish Name</label>
			<input id="fname" name="fname" type="text" placeholder="Enter Name" class="form-control"  required>
		</div>
		<div class="form-group">
		<label for="preferance">Dish Type</label>
		<br>
		<input type="radio" name="preferance" value="NonVeg" required>NonVeg
		<input type="radio" name="preferance" value="Veg" required>Veg
		</div>
		<div class="form-group">
			<label for="price">Price</label>
			<input id="fpass" name="fprice" type="text" placeholder="Enter Price" class="form-control" required>
		</div>
		<button class="btn btn-info btn-lg" type="submit" >Add</button>
		</div>
		<hr>
		</form>
</div>
</div>
</div>
</div>
</body>
</html>