<%@page import="com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter"%>
<%@page import="sun.org.mozilla.javascript.internal.Context"%>
<%@page import="javax.xml.ws.spi.http.HttpContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="MBank.core.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Client client=(Client)request.getSession().getAttribute("client");
%>


	<form method="POST" action="Controler">
	<fieldset style="width:500px;">
	<legend>Update Client</legend>
	<table border="0">
	<tr>
		<td>New name:</td>
		<td><input type="text" name="newName" value="<%=client.getUsername()%>"><br></td>
	</tr>
	<tr>
		<td>New Password:</td>
		<td><input type="password" name="newPass" value="<%=client.getPassword()%>"><br></td>
	</tr>
	<tr>
		<td>New Address:</td>
		<td><input type="text" name="newAddress" value="<%=client.getAddress()%>"><br></td>
		
	</tr>
	<tr>	
		<td>New Phone:</td>
		<td><input type="text" name="newPhone" value="<%=client.getPhone()%>"><br></td>
	</tr>
	<tr>	
		<td>New Email:</td>
		<td><input type="text" name="newEmail" value="<%=client.getEmail()%>"><br></td>
	</tr>
	<tr>	
		<td><input type="submit" value="Update"></td>
		</tr>
		<%
			//Client newClient=new Client();
			//newClient.setUsername(request.getParameter("newName"));
			//newClient.setAddress(request.getParameter("newAddress"));
			//request.getSession(false).setAttribute("newClient",newClient);
			//System.out.println(newClient.getAddress()+"TEST1");
			//System.out.println("Test001");
			//String address=(String)getInitParameter("newAddress");
			//System.out.println(address);
		%>
	</table>
	</fieldset>
	</form>
</body>
</html>