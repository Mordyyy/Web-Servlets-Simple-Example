package servlets;

import DB.StoreDAO;
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

@WebServlet("")
public class WelcomeServlet extends HttpServlet {
    private ProductList productList;
    private StoreDAO storeDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        productList = (ProductList) request.getServletContext().getAttribute("products");
        if(!productList.isFilled()) {
            try {
                productList.fillProductList(request);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        request.setAttribute("allProducts", productList);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
