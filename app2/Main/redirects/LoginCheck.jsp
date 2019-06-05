<%@ page contentType="text/html; charset=utf-8" language="java" import="javax.xml.parsers.DocumentBuilderFactory,javax.xml.parsers.DocumentBuilder,org.w3c.dom.*" errorPage="" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
<%
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

DocumentBuilder db = dbf.newDocumentBuilder();

Document doc = db.parse("webapps/app2/Main/data/users.xml");

NodeList UserID = doc.getElementsByTagName("UserID");
NodeList UserType = doc.getElementsByTagName("UserType");
NodeList UserName = doc.getElementsByTagName("UserName");
NodeList Password = doc.getElementsByTagName("Password");
NodeList FirstName = doc.getElementsByTagName("FirstName");
NodeList LastName = doc.getElementsByTagName("LastName");
NodeList Email = doc.getElementsByTagName("Email");
NodeList Department = doc.getElementsByTagName("Department");
NodeList Wallet = doc.getElementsByTagName("Wallet");

int checkOkay = 0;
String username=request.getParameter("username");
String password=request.getParameter("password");
String userType;
String[] usernamesArray = new String[UserName.getLength()];
String[] passwordsArray = new String[Password.getLength()];
String[] userTypeArray = new String[UserType.getLength()];
String[] userIDArray = new String[UserID.getLength()];
String[] userFnameArray = new String[UserID.getLength()];
String[] userLnameArray = new String[UserID.getLength()];
String[] userEmailArray = new String[UserID.getLength()];
String[] userDepartmentArray = new String[UserID.getLength()];
String[] userWalletArray = new String[UserID.getLength()];

int i;
for(i=0;i<=UserType.getLength()-1;i++)
{
	userIDArray[i] = UserID.item(i).getFirstChild().getNodeValue();
	usernamesArray[i] = UserName.item(i).getFirstChild().getNodeValue();
	passwordsArray[i] = Password.item(i).getFirstChild().getNodeValue();
	userTypeArray[i] = UserType.item(i).getFirstChild().getNodeValue();
	userFnameArray[i] = FirstName.item(i).getFirstChild().getNodeValue();
    userLnameArray[i] = LastName.item(i).getFirstChild().getNodeValue();
    userEmailArray[i] = Email.item(i).getFirstChild().getNodeValue();
    userDepartmentArray[i] = Department.item(i).getFirstChild().getNodeValue();
    userWalletArray[i] = Wallet.item(i).getFirstChild().getNodeValue();
}
int k;
for(k=0;k<=UserType.getLength()-1;k++)
{
	if(username.equals(usernamesArray[k]) && (password.equals(passwordsArray[k])))
	{
		session.setAttribute("username",username);
		checkOkay = 1;
		userType = userTypeArray[k];
		session.setAttribute("userType", userType);
		session.setAttribute("FirstName", userFnameArray[k]);
		session.setAttribute("LastName", userLnameArray[k]);
		session.setAttribute("Email", userEmailArray[k]);
		session.setAttribute("Department", userDepartmentArray[k]);
		session.setAttribute("Wallet", userWalletArray[k]);
		if(userType.equals("Student"))
		{
			response.sendRedirect("../home/StudentHome.jsp");
			return;
		}
		else if(userType.equals("Advisor"))
		{
			response.sendRedirect("../home/AdvisorHome.jsp");
			return;
		}
		else if(userType.equals("Admin"))
		{
			response.sendRedirect("../home/AdminHome.jsp");
			return;
		}
		else
		{
			response.sendRedirect("../index.jsp");
			return;
		}
	}
}

if(checkOkay == 0)
{
	response.sendRedirect("../index.jsp");
}
%> 


</body> 
</html>