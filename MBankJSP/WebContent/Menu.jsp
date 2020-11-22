<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset='utf-8'>
<meta name="viewport" content="width=device-width, initial-scale=2">
<link rel="stylesheet" href="styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="script.js"></script>

<title>Insert title here</title>
</head>
<body>
<div id='cssmenu'>
<ul>
   <li><a href='index.html'><span>Log Out</span></a></li>
   <li class='active has-sub'><a href='#'><span>Client</span></a>
      <ul>
         <li><a href='Controler?m=1 '><span>Update Client</span></a></li>
         <li><a href='Controler?m=2 '><span>Withdraw from account</span></a></li>
         <li><a href='Controler?m=3 '><span>Deposit to account</span></a></li>
         <li><a href='Controler?m=4 '><span>Create new deposit</span></a></li>
         <li><a href='Controler?m=5 '><span>Pre-open deposit</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Detals</span></a>
      <ul>
         <li><a href='Controler?m=6 '><span>View Client detals</span></a></li>
         <li><a href='Controler?m=7 '><span>View account detals</span></a></li>
         <li><a href='Controler?m=8 '><span>View Client deposit</span></a></li>
         <li><a href='Controler?m=9 '><span>View Client activity</span></a></li>
         <li><a href='Controler?m=10 '><span>View system property</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Help</span></a>
      <ul>
         <li><a href='Controler?m=11 '><span>About this Application</span></a></li>
         <li><a href='Controler?m=12 '><span>Version</span></a></li>
      </ul>
   </li>
</ul>
</div>
</body>
</html>