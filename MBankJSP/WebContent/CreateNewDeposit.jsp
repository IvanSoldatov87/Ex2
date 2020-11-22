<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="MBank.core.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new deposit</title>
</head>
<body>
<form method="POST" action="Controler">
	<fieldset style="width:500px;">
	<legend>Create new deposit</legend>
	<table border="0">
	<tr>
		<td>Balance:</td>
		<%
		Client client=(Client)request.getSession().getAttribute("client");
		%>
		<td><%=MBankST.getInstance().getActionClient().getAccount(client.getClient_id()).getBalance()%><br></td>
	</tr>
	<tr>
	 <td>Years :</td>
	 <td>
		<select name=years>
		<option value=0> 0 </option>
		<option value=1> 1 </option>
		<option value=2> 2 </option>
		<option value=3> 3 </option>
		<option value=4> 4 </option>
		</select>
		</td>
		<td>Mounts :</td>
		 <td>
		<select name=monus>
		<option value=0>  0  </option>
		<option value=1>  1  </option>
		<option value=2>  2  </option>
		<option value=3>  3  </option>
		<option value=4>  4  </option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Deposit :</td>
		<td><input type="text" name="deposit" value=""><br></td>
	</tr>
	<tr>
		<td><input type="submit" value="Create"></td>
	</tr>
	</table>
	</fieldset>
	</form>


</body>
</html>