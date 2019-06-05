<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<% //IMPORT EVERYTHING NEEDED TO READ/WRITE XML FILES %>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.io.File,javax.xml.parsers.DocumentBuilder,javax.xml.parsers.ParserConfigurationException,javax.xml.transform.Transformer,javax.xml.parsers.DocumentBuilderFactory,javax.xml.transform.TransformerException,javax.xml.transform.TransformerFactory,javax.xml.transform.dom.DOMSource,javax.xml.transform.stream.StreamResult,javax.xml.parsers.DocumentBuilder,org.w3c.dom.*" errorPage="" %>

<%

//Initiate Reader
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

DocumentBuilder db = dbf.newDocumentBuilder();

Document docReader = db.parse("webapps/app2/Main/data/users.xml");

NodeList UserID = docReader.getElementsByTagName("UserID");
NodeList UserType = docReader.getElementsByTagName("UserType");
NodeList UserName = docReader.getElementsByTagName("UserName");
NodeList Password = docReader.getElementsByTagName("Password");
NodeList FirstName = docReader.getElementsByTagName("FirstName");
NodeList LastName = docReader.getElementsByTagName("LastName");
NodeList Email = docReader.getElementsByTagName("Email");
NodeList Department = docReader.getElementsByTagName("Department");
NodeList Wallet = docReader.getElementsByTagName("Wallet");

NodeList users = docReader.getElementsByTagName("user");

String[] userIDArray = new String[users.getLength()];
String[] usernamesArray = new String[users.getLength()];
String[] passwordsArray = new String[users.getLength()];
String[] userTypeArray = new String[users.getLength()];
String[] userFnameArray = new String[users.getLength()];
String[] userLnameArray = new String[users.getLength()];
String[] userEmailArray = new String[users.getLength()];
String[] userDepartmentArray = new String[users.getLength()];
String[] userWalletArray = new String[users.getLength()];

for(int i=0;i<=users.getLength()-1;i++)
{
	userIDArray[i] = UserID.item(i).getFirstChild().getNodeValue();
    userTypeArray[i] = UserType.item(i).getFirstChild().getNodeValue();
    usernamesArray[i] = UserName.item(i).getFirstChild().getNodeValue();
	passwordsArray[i] = Password.item(i).getFirstChild().getNodeValue();
    userFnameArray[i] = FirstName.item(i).getFirstChild().getNodeValue();
    userLnameArray[i] = LastName.item(i).getFirstChild().getNodeValue();
    userEmailArray[i] = Email.item(i).getFirstChild().getNodeValue();
    userDepartmentArray[i] = Department.item(i).getFirstChild().getNodeValue();
    userWalletArray[i] = Wallet.item(i).getFirstChild().getNodeValue();
}

%>

<%

String registerUserType=request.getParameter("registerUserType");
String registerUsername=request.getParameter("registerUsername");
String registerPassword=request.getParameter("registerPassword");
String registerFname=request.getParameter("registerFname");
String registerLname=request.getParameter("registerLname");
String registerEmail=request.getParameter("registerEmail");
String registerUserDepartment=request.getParameter("registerUserDepartment");

%>

<%!

//The symbols above are for declaring functions within a jsp file


//Functions to create xml nodes to be written
public static Node getUser(Document doc, String id, String usertype, String username, String password, String fname, String lname, String email, String department, String wallet) {
        Element user = doc.createElement("user");
        user.appendChild(getUserElements(doc, user, "UserID", id));
        user.appendChild(getUserElements(doc, user, "UserType", usertype));
        user.appendChild(getUserElements(doc, user, "UserName", username));
        user.appendChild(getUserElements(doc, user, "Password", password));
        user.appendChild(getUserElements(doc, user, "FirstName", fname));
        user.appendChild(getUserElements(doc, user, "LastName", lname));
        user.appendChild(getUserElements(doc, user, "Email", email));
        user.appendChild(getUserElements(doc, user, "Department", department));
        user.appendChild(getUserElements(doc, user, "Wallet", wallet));
        return user;
    }
 %>


 <%!
    //utility method to create text node
    public static Node getUserElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

%>

<%
//Setting up the writing to the xml file
DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder icBuilder;
 
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            //creating the root element of users
            Element mainRootElement = doc.createElementNS("The list of all the users.", "Users");
            doc.appendChild(mainRootElement);

            for(int p = 0; p < users.getLength(); p++)
            {
                mainRootElement.appendChild(getUser(doc, userIDArray[p], userTypeArray[p], usernamesArray[p], passwordsArray[p], userFnameArray[p], userLnameArray[p], userEmailArray[p], userDepartmentArray[p], userWalletArray[p]));
            }


            //compensating for deleted users
            String lastUserID = UserID.item(users.getLength()-1).getFirstChild().getNodeValue();
            int makingLastUserIdInt = Integer.parseInt(lastUserID);
            int newUserID = makingLastUserIdInt + 1;

            mainRootElement.appendChild(getUser(doc, Integer.toString(newUserID), registerUserType, registerUsername, registerPassword, registerFname, registerLname, registerEmail, registerUserDepartment, "0"))
 

            ;
 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            //The file needs to be there prior to writing, even if it is blank
            StreamResult console = new StreamResult(new File("webapps/app2/Main/data/users.xml"));
            transformer.transform(source, console);


%>


<h1>SUCCESS!</h1>
<p>You have officially registered! Please return to the <a href="../index.jsp">LOG-IN.</a></p>



</body> 
</html>