<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="MBank.core.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;border:none;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#669;background-color:#e8edff;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#039;background-color:#b9c9fe;}
.tg .tg-vn4c{background-color:#D2E4FC}
.tg .tg-17z1{font-weight:bold;font-size:12px;font-family:"Times New Roman", Times, serif !important;;text-align:center}
</style>

<title>Welcom</title>
</head>
<body>
<%
    	Client client=(Client)request.getSession().getAttribute("client");
		//System.out.println(client.getUsername());
%>
<h3>Welcome <%=client.getUsername()%></h3>

<table class="tg">
  <tr>
    <th class="tg-17z1">ID</th>
    <th class="tg-031e">Name</th>
    <th class="tg-031e">Password</th>
    <th class="tg-031e">Address</th>
    <th class="tg-031e">Phone</th>
    <th class="tg-031e">Email</th>
    <th class="tg-031e">Type</th>
    <th class="tg-031e">Comments</th>
  </tr>
  <tr>
    <td class="tg-vn4c"><%=client.getClient_id()%></td>
    <td class="tg-vn4c"><%=client.getUsername()%></td>
    <td class="tg-vn4c">***<%=client.getPassword().substring(1)%></td>
    <td class="tg-vn4c"><%=client.getAddress()%></td>
    <td class="tg-vn4c"><%=client.getPhone()%></td>
    <td class="tg-vn4c"><%=client.getEmail()%></td>
    <td class="tg-vn4c"><%=client.getType()%></td>
    <td class="tg-vn4c"><%=client.getComment()%></td>
  </tr>
  </table>
</body>
</html>