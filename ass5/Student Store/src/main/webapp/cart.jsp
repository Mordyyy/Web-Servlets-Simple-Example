<%@ page import="java.util.ArrayList" %>
<%@ page import="Cart.Cart" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="Products.Product" %>
<%@ page import="Products.ProductList" %>
<%@ page import="org.w3c.dom.ls.LSOutput" %><%--
  Created by IntelliJ IDEA.
  User: Mordy
  Date: 7/5/20
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping cart</title>
</head>
<body>
    <h1>Shopping cart</h1>
    <%Cart cart = (Cart)request.getAttribute("cart");
        ArrayList<String> ids = cart.getAll();
        ProductList productList = (ProductList) request.getServletContext().getAttribute("products");
    %>
    <form action = "/cart" method = "POST">
    <ul>
        <%for(String id : ids){
            Product product = productList.getProduct(id);
        %>
        <li>
            <input type="text" value="<%=cart.getItemQuantity(id)%>" name=<%=id%>>
            <%=product.getName()%>, <%=product.getPrice()%>
        </li>
        <%}%>
    </ul>
    <%double result = 0;
        for(String id : ids){
            Product product = productList.getProduct(id);
            result += cart.getItemQuantity(id) * product.getPrice();
        }%>
    <label>Total: <%=result%></label><br>
        <button type="submit">Update cart</button>
    </form>
        <a href="/"> Continue to shopping</a>
    </form>
</body>
</html>
