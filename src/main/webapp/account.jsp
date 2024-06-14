<%@page import="com.Entity.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="account.css" rel="stylesheet" type="text/css">
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
<%@include file="msg.jsp" %>
<nav class="navbar bg-body-tertiary" id="logout">
<div class="container-fluid" >
<a class="btn btn-danger" href="logout">Logout</a>
<form action="readtxn">
<input type="hidden" name="uid" value="<%=check %>">
<button class="btn btn-info">Transaction History</button>
<a class="btn btn-info" href="accountinfo.jsp">Account Info</a>
</form>

</div>
</nav>

<!-- start of account services -->
<h1 class="display-6 text-center text-light" id="aservice">Account Services</h1>


<div class="container border text-light" id="service">
<div class="row overflow-hidden">
<div class="col col-md-4">
	<div>
		<span>Deposit Money</span>
		<form action="deposit" >
		<label for="am">Enter Amount</label>
		<input type="text" name="am" class="form-control" id="am">
		
		<input type="hidden" name="uid" value="<%=check%>">
		<button class="btn btn-success mt-3">Deposit</button>
		</form>
	</div>
</div>

<div class="col col-md-4">
	<div>
		<span>Withdraw Money</span>
		<form action="withdraw" >
		<label for="am">Enter Amount</label>
		<input type="text" name="am" class="form-control" id="am">
		
		<input type="hidden" name="uid" value="<%=check%>">
		<button class="btn btn-success mt-3">Withdraw</button>
		</form>
	</div>
</div>

<div class="col col-md-4">
	<div>
		<span>Transfer Money</span>
		<form action="transfer" >
		<label for="am">Enter Amount</label>
		<input type="text" name="am" class="form-control" id="am">
		
		<label for="acb">Enter Account number</label>
		<input type="text" name="acb" class="form-control" id="acb">
		
		<input type="hidden" name="uid" value="<%=check%>">
		
		<button class="btn btn-success mt-3">Transfer</button>
		</form>
	</div>
</div>
<div class="col col-md-4">
	<div>
	<span>Account Balance</span>
	<p><%=ac.getBal() %></p>
	</div> 	
</div>
</div>
</div>

<%}
else
{
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>