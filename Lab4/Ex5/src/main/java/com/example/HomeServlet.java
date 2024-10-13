package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        if (page == null) {
            // If no page parameter is passed, display a welcome message (or you can redirect to a default page)
            response.setContentType("text/html");
            response.getWriter().write("<h1>Welcome to our website</h1>");
        } else if ("about".equals(page) || "contact".equals(page) || "help".equals(page)) {
            // If valid page parameters are passed, forward to the appropriate JSP file
            String jspPath = page + ".jsp";
            RequestDispatcher reqDispatcher = request.getRequestDispatcher(jspPath);
            reqDispatcher.forward(request, response);
        }
    }
}
