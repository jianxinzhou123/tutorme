<html>
<head>
<title>Admin Home</title>
</head>

<body>

<%if(session.getAttribute("userType").equals("Admin")){%>

<h1>Admin Home Page</h1>
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