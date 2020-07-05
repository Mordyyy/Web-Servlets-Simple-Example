<%--
  Created by IntelliJ IDEA.
  UserPackage.User: Mordy
  Date: 6/27/20
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Account</title>
</head>
<form action="/register" method="post">
<body>
<h1><b><%=request.getAttribute("header")%></b></h1> <br>
<p><%=request.getAttribute("paragraph")%></p> <br>
User Name: <input type="text" name = "Username"> <br>
Password:   <input type="password" name = "Password">
<button type= "submit"> Login</button>
</body>
</form>
</html>
