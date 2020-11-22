<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="MBank.core.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pre-open Deposit</title>
</head>
<body>
<form method="POST" action="Controler">
	<fieldset style="width:500px;">
	<legend>Update Client</legend>
	<table border="0">
	<tr>
		<td>Balance:</td>
		<%
		Client client=(Client)request.getSession().getAttribute("client");
		%>
		<td><%=MBankST.getInstance().getActionClient().getAccount(client.getClient_id()).getBalance()%><br></td>
	</tr>
	<tr>
		<td>Pre-open Deposit:</td>
		<td><input type="text" name="preOpen"><br></td>
	</tr>
	<tr>
		<td><input type="submit" value="PreOpen"></td>
	</tr>
	</table>
	</fieldset>
	</form>
</body>
</html>