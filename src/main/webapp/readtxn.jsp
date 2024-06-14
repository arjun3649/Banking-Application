<%@page import="java.util.List"%>
<%@page import="com.Entity.TxnHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="readtxn.css" rel="stylesheet" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
</head>
<body>
<%
String check=(String)session.getAttribute("check");
if(check!=null)
{
	List<TxnHistory> al = (List<TxnHistory>) session.getAttribute("al");
%>

<h1 class="display-6 text-center text-light" id="head">Transaction History</h1>
<div class="text-center">
<table class="table table-bordered w-50 text-light table-dark table-striped-columns table-hover" id="table">
<thead>
<tr>
<th>Account Number</th>
<th>Amount</th>
<th>TStatus</th>
<th>Date</th>
<th>Available Bal</th>
</tr>
</thead>
<tbody>
<%
for(TxnHistory txn:al)
{
%>
<tr>
<td><%=txn.getAcno() %></td>
<td><%=txn.getAmount() %></td>
<td><%=txn.getTstatus() %></td>
<td><%=txn.getDate()%></td>
<td><%=txn.getBal() %></td>
</tr>
<%} %>
</tbody>
</table>
</div>
<a href="accountu" class="btn btn-warning btn-lg">Back</a>
<%}
else
{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>