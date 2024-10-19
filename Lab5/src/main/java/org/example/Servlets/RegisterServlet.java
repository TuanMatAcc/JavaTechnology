package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DAO.AccountDAO;
import org.example.POJO.Account;

import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("password-confirm");

        if(username == null || username.isEmpty()) {
            request.getSession().setAttribute("flashMessage", "Username is required");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else if(email == null || email.isEmpty()) {
            request.getSession().setAttribute("flashMessage", "Email is required");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else if(password == null || password.isEmpty()) {
            request.getSession().setAttribute("flashMessage", "Password is required");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else if(!password.equals(confirmPassword)) {
            request.getSession().setAttribute("flashMessage", "Passwords do not match");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else {
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.add(new Account(username, email, password));
            response.sendRedirect("login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
