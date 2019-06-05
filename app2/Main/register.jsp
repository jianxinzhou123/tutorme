 <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register Page</title>
        <link rel="stylesheet" href="css/register.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>

      <form action="redirects/RegisterNewUser.jsp" method="post">
      
        <h1>Register For Advising System!</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Your basic info</legend>
          <label for="name">First Name:</label>
          <input type="text" id="name" name="registerFname">

          <label for="name">Last Name:</label>
          <input type="text" id="name" name="registerLname">
          
          <label for="mail">Email:</label>
          <input type="text" id="mail" name="registerEmail">

          <label for="password">Username:</label>
          <input type="text" id="text" name="registerUsername">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="registerPassword">

        <fieldset>
        <label for="userType">Who Are You?</label>
          <select id="userType" name="registerUserType">
          <option value="Student">Student</option>
          <option value="Advisor">Advisor</option>
          </select>
        
        </fieldset>

        <fieldset>
        <label for="department">Which Department Are You In?</label>
          <select id="department" name="registerUserDepartment">
          <option value="Engineering and Computer Science">Engineering and Computer Science</option>
          <option value="Visual and Performing Arts">Visual and Performing Arts</option>
          </select>
        
        </fieldset>


        <button type="submit">Register</button>
      </form>
      <form action = "index.jsp">
        <button type="submit">Back</button>
      </form>
      
    </body>
</html>