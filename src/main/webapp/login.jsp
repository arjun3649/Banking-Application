<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="login.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h1 class="display-6 text-center" id="head">login Page</h1>
<%@include file="msg.jsp" %>

<div class="container w-25" id="con">
<form action="login" id="bg" >
<label for="uid">Enter UserI Id</label>
<input type="text" name="uid" class="form-control" id="uid">

<label for="upass">Enter Password</label>
<input type="password" name="upass" class="form-control" id="upass">

<div class="text-center"><button class="btn btn-success mt-3">Login</button></div>

<div class="text-center mt-3">
    Not have an Account?<a href="signup.jsp">SignUp</a>
</div>
</form>
</div>
</body>
</html>