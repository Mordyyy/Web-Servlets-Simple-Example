package servlets;

import UserInfo.UserDAO;
import UserPackage.User;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    private UserDAO data;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        request.setAttribute("header", "Welcome To Homework 5");
        request.setAttribute("paragraph", "Please log in");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        data = (UserDAO)request.getServletContext().getAttribute("db");
        String userName = request.getParameter("Username");
        String password = request.getParameter("Password");
        RequestDispatcher loginDispatcher = request.getRequestDispatcher("login.jsp");
        if(userName.equals("") || password.equals("")){
            request.setAttribute("header", "Please try again");
            request.setAttribute("paragraph", "Invalid format of input");
            loginDispatcher.forward(request,response);
        }else if (data.successfulLogin(new User(userName,password))){
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            request.setAttribute("header", "Welcome " + userName);
            rd.forward(request,response);
        }else{
            request.setAttribute("header", "Please Try Again");
            request.setAttribute("paragraph", "Either your user name or password is incorrect. Please try again.");
            loginDispatcher.forward(request,response);
        }
    }
}
