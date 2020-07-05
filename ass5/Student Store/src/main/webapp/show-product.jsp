<%@ page import="Products.ProductList" %>
<%@ page import="Products.Product" %><%--
  Created by IntelliJ IDEA.
  User: Mordy
  Date: 7/5/20
  Time: 1:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<% ProductList productList = (ProductList) request.getServletContext().getAttribute("products");
   Product product = productList.getProduct((String)request.getSession().getAttribute("id"));%>
<head>
    <title><%=product.getName()%></title>
</head>
<body>
    <h1><%=product.getName()%></h1>
    <img src="store-images/<%=product.getImageFile()%>"/><br>
    <p>$<%=product.getPrice()%></p>
    <form action="/cart" method = get>
        <button type="submit">Add to Cart</button>
    </form>
</body>
</html>
