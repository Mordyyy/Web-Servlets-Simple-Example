package servlets;

import Products.ProductList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
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
        String id = request.getParameter("id");
        RequestDispatcher rd = request.getRequestDispatcher("show-product.jsp");
        request.getSession().setAttribute("id", id);
        rd.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
