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

<title>View Client Deposit</title>
</head>
<body>
	<%
		Client client=(Client)session.getAttribute("client");
		Account acc = MBankST.getInstance().getActionClient().accountDetails(client.getClient_id());
	%>
<table class="tg">
  <tr>
    <th class="tg-17z1">Client ID</th>
    <th class="tg-031e">Account ID</th>
    <th class="tg-031e">Balance</th>
    <th class="tg-031e">Credit limit</th>
  </tr>
  <tr>
    <td class="tg-vn4c"><%=acc.getClient_id()%></td>
    <td class="tg-vn4c"><%=acc.getAccount_id()%></td>
    <td class="tg-vn4c"><%=acc.getBalance()%></td>
    <td class="tg-vn4c"><%=acc.getCredit_limit()%></td>
  </tr>
 </table>
</body>
</html>