<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Log-in</title>

  <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
<%
    String setNulls = "null";
    session.setAttribute("username", setNulls);
    session.setAttribute("userType", setNulls);
%>

  <div class="login-card">
    <h1>Advisor System Log-In</h1><br>
  <form action="redirects/LoginCheck.jsp" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" name="login" class="login login-submit" value="login">
  </form>
    
  <div class="login-help">
    <a href="register.jsp">Register</a>
  </div>
</div>

  

</body>

</html>
