<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset='utf-8'>


<link rel="stylesheet" href="BG.css">

<title>Tem</title>
</head>
<body id="bg">
	<%@ include file="Menu.jsp"%>
	<%
		String nextPage=(String)request.getAttribute("nextPage"); 
		//System.out.println(nextPage);
	%>
	
	<jsp:include page="<%=nextPage%>"/>	
</body>
</html>