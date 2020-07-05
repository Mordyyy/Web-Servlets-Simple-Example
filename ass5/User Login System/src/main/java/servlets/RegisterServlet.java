package servlets;

import UserInfo.UserDAO;
import UserPackage.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        request.setAttribute("header", "Create New Account");
        request.setAttribute("paragraph", "Please enter proposed name and password");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO data = (UserDAO)request.getServletContext().getAttribute("db");
        String userName = request.getParameter("Username");
        String password = request.getParameter("Password");
        if(userName.equals("") || password.equals("")){
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            request.setAttribute("header", "Please try again");
            request.setAttribute("paragraph", "Invalid format of input");
            rd.forward(request,response);
        }else if (!data.containsUserName(userName)){    // Good username an pass
            data.addUser(new User(userName,password));
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            request.setAttribute("header", "Welcome " + userName);
            rd.forward(request,response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            request.setAttribute("header", "The Name " + userName + " Is Already In Use");
            request.setAttribute("paragraph", "Please enter another name and password.");
            rd.forward(request,response);
        }


    }
}
