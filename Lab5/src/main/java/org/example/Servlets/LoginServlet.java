package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.DAO.AccountDAO;
import org.example.POJO.Account;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            request.setAttribute("username", "");
            request.setAttribute("password", "");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        for(Cookie c : cookies) {
            if(c.getName().equals("username")) {
                request.setAttribute("username", c.getValue());
            }
            if(c.getName().equals("password")) {
                request.setAttribute("password", c.getValue());
            }
        }
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Example login validation
        if (username == null || username.isEmpty()) {
            request.getSession().setAttribute("flashMessage", "Username is required");
            response.sendRedirect("login.jsp");
        } else if (password == null || password.isEmpty()) {
            request.getSession().setAttribute("flashMessage", "Password is required");
            response.sendRedirect("login.jsp");
        }
        else {
            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.get(username);
            if (account == null || !account.getPassword().equals(password)) {
                request.getSession().setAttribute("flashMessage", "Invalid username or password");
                response.sendRedirect("login.jsp");
            } else {
                String isRemember = request.getParameter("remember");
                if(isRemember != null && isRemember.equals("on")) {
                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);  // In production, encrypt this password!

                    usernameCookie.setMaxAge(30 * 24 * 60 * 60);
                    passwordCookie.setMaxAge(30 * 24 * 60 * 60);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);

                }
                HttpSession session = request.getSession();
                session.setAttribute("user", account);
                response.sendRedirect("/prodman");
            }
        }

    }

}
