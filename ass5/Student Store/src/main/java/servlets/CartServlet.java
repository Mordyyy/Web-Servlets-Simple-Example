package servlets;

import Cart.Cart;
import Products.Product;
import Products.ProductList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
    private ProductList productList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productList = (ProductList) request.getServletContext().getAttribute("products");
        if(!productList.isFilled()) {
            try {
                productList.fillProductList(request);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cart.addItem((String) request.getSession().getAttribute("id"));
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        request.setAttribute("cart", cart);
        request.setAttribute("productList", productList);
        rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        ArrayList<String> all = cart.getAll();
        for(String id : all){
            String num = (String) request.getParameter(id);
            System.out.println(num);
            int number = Integer.parseInt(num);
            cart.updateCart(id,number);
        }
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        request.setAttribute("cart", cart);
        request.setAttribute("productList", productList);
        rd.forward(request,response);
    }
}
