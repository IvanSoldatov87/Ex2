<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="MBank.core.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset='utf-8'>
	<meta name="viewport" content="width=device-width, initial-scale=2">
	<link rel="stylesheet" href="styles.css">
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script src="script.js"></script>
	<style type="text/css">
	.tg  {border-collapse:collapse;border-spacing:0;border-color:#aabcfe;border:none;}
	.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#669;background-color:#e8edff;}
	.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:0px;overflow:hidden;word-break:normal;border-color:#aabcfe;color:#039;background-color:#b9c9fe;}
	.tg .tg-vn4c{background-color:#D2E4FC}
	.tg .tg-17z1{font-weight:bold;font-size:12px;font-family:"Times New Roman", Times, serif !important;;text-align:center}
	</style>
	<%
		SysProperties sysp= new SysProperties();
		sysp=(SysProperties)request.getAttribute("sysp");
	%>
	<title>View System</title>
</head>
<body>
<table class="tg">
  <tr>
    <th class="tg-17z1">Commission rate</th>
    <th class="tg-031e">Gold credit limit</th>
    <th class="tg-031e">Gold daily interest</th>
    <th class="tg-031e">Gold deposit commission</th>
    <th class="tg-031e">Gold deposit rate</th>
    <th class="tg-031e">Platinum credit limit</th>
    <th class="tg-031e">Platinum daily interest</th>
  </tr>
  <tr>
 <td class="tg-vn4c"><%=sysp.getCommision_rate()%></td>
    <td class="tg-vn4c"><%=sysp.getGold_credit_limit()%></td>
    <td class="tg-vn4c"><%=sysp.getGold_daily_interest()%></td>
    <td class="tg-vn4c"><%=sysp.getGold_deposit_commission()%></td>
    <td class="tg-vn4c"><%=sysp.getGold_deposit_rate()%></td>
    <td class="tg-vn4c"><%=sysp.getPlatinum_credit_limit()%></td>
    <td class="tg-vn4c"><%=sysp.getPlatinum_daily_interest()%></td>
  </tr>
  <tr>
  	<th class="tg-031e">Platinum deposit commission</th>
    <th class="tg-031e">Platinum deposit rate</th>
    <th class="tg-031e">Regular credit limit</th>
    <th class="tg-031e">Regular daily interest</th>
    <th class="tg-031e">Regular deposit commission</th>
    <th class="tg-031e">Regular deposit rate</th>
    <th class="tg-031e">Pre open free</th>
  </tr>
  <tr>
  <td class="tg-vn4c"><%=sysp.getPlatinum_deposit_commission()%></td>
    <td class="tg-vn4c"><%=sysp.getPlatinum_deposit_rate()%></td>
    <td class="tg-vn4c"><%=sysp.getRegular_credit_limit()%></td>
    <td class="tg-vn4c"><%=sysp.getRegular_daily_interest()%></td>
    <td class="tg-vn4c"><%=sysp.getRegular_deposit_commission()%></td>
    <td class="tg-vn4c"><%=sysp.getRegular_deposit_rate()%></td>
    <td class="tg-vn4c"><%=sysp.getPre_open_free()%></td>
  </tr>
 </table>
</body>
</html>