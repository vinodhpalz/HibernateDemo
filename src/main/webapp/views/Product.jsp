<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<a href = "/HibernateDemo/productsss">List Products</a>
<a href = "/HibernateDemo/privatePage">User Page</a>
<form action="/HibernateDemo/success" method="post">
  <div class="form-group">
    <label for="pname">Product Name:</label>
    <input type="text" class="form-control" id="pname" name="pname" placeholder="Enter Product Name">
  </div>
  <div class="form-group">
    <label for="pcost">Product Cost:</label>
    <input type="text" class="form-control" id="pcost" name="pcost" placeholder="Enter the cost of the product">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>