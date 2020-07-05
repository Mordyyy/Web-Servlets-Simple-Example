<html>
<head>
    <title> Welcome</title>
</head>
<body>
<h1><%=request.getAttribute("header")%></h1>
<p> <%= request.getAttribute("paragraph") %></p>
<form action="/" method="post">
    User Name: <input type="text" name = "Username"> <br>
    Password: <input type="password" name = "Password">
    <button type= "submit"> Login</button> <br>
    <a href="/register">Create New Account</a>
</form>
</body>
</html>
