<html>
<head>
<title>Advisor Home</title>
</head>

<body>
<%if(session.getAttribute("userType").equals("Advisor")){%>

<h1>Advisor Home Page</h1>
<p>Welcome <%= session.getAttribute("username") %>!</p>
		
<%
}
else
{
	response.sendRedirect("../redirects/PermissionError.jsp");
}
%>

</body>
</html>