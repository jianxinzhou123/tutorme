<html>
<head>
<title>Student Home</title>
</head>

<body>
<%if(session.getAttribute("userType").equals("Student")){%>

<h1>Student Home Page</h1>
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