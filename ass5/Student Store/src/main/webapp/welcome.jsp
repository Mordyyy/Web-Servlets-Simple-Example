<%@ page import="Products.ProductList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Products.Product" %><%--
  Created by IntelliJ IDEA.
  User: Mordy
  Date: 7/4/20
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Store </title>
</head>

<body>
    <h1>Student Store</h1>
    <p>Items available:</p>
    <form action="" method="post">
    <ul>
        <% ProductList productList = (ProductList) request.getAttribute("allProducts");
        ArrayList<Product>products =  productList.getProductList();
        for(Product product: products){%>
        <li><a href="/product?id=<%=product.getProductId()%>"><%=product.getName()%></a> </li>
        <%}%>
    </ul>
    </form>
</body>
</html>
