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
<script>
    function validate()
    {
    	if(document.getElementById("fpass").value == document.getElementById("fpass1").value )
    		{
    		alert("Success");
    		return true;
        	
    		}
    	else
    		{
    		alert("Password and confirm password did not match");
    		return false;
    		}
    }
</script>
<body>
<div class="text-center">
<h1>FoodShala</h1>
</div>
<hr>
<div class="container-fluid bg-dark ">
<div class="container bg-light">
<div class="row justify-content-center">
<div  class="col-md-5 offset-md-1 ">
<form role="form" method="post" onsubmit="return validate()" action="InsertRestaurant">
			<h2>Register</h2>
			<div class="form-group">
			<label for="name">Name</label>
			<input id="fname" name="fname" type="text" placeholder="Enter Name" class="form-control"  required>
		</div>
		<div class="form-group">
			<label for="pass">Password</label>
			<input id="fpass" name="fpass" type="password" placeholder="Enter Password" class="form-control" required>
		</div>
		<div class="form-group">
			<label for="conpass">Confirm Password</label>
			<input id="fpass1" name="fpass1" type="password" placeholder="Confirm Password" class="form-control" required>
		</div>
		<div  class="offset-md-3 ">
		<button class="btn btn-info btn-lg" type="submit" >Register</button>
		</div>
		<hr>
		</form>
</div>
</div>
</div>
</div>
</body>
</html>