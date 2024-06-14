<%@page import="com.Entity.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="accinfo.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
<%
String check =(String)session.getAttribute("check");
if(check!=null)
{
	Account ac =(Account) session.getAttribute("ac");
%>

<h1 class="display-6 text-center text-light" id="head">Account Page</h1>

<div class="container border text-light mt-4" id="page">
<div class="row overflow-hidden">
<div class="col col-md-4">
	<div>
	<span>User Id :</span>
	<p><%=ac.getUserid() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>User Password :</span>
	<p><%=ac.getPass() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Contact :</span>
	<p><%=ac.getContact() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Email :</span>
	<p><%=ac.getEmail() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>City :</span>
	<p><%=ac.getCity() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Account Holder Name :</span>
	<p><%=ac.getAcholname() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Account Type :</span>
	<p><%=ac.getActype() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Atm :</span>
	<p><%=ac.getAtm() %></p>
	</div>
</div>

<div class="col col-md-4">
	<div>
	<span>Account Number :</span>
	<p><%=ac.getAcno() %></p>
	</div>
</div>


</div>
</div>

<a class="btn btn-warning btn-lg" href="accountu" id="button">←Back</a>
<%} %>

</body>
</html>