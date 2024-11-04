package com.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] favoriteIDE = request.getParameterValues("favorite_ide[]");
        String toeic = request.getParameter("toeic");
        String message = request.getParameter("message");

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("birthday", birthday);
        request.setAttribute("birthtime", birthtime);
        request.setAttribute("gender", gender);
        request.setAttribute("country", country);
        request.setAttribute("ide", favoriteIDE);
        request.setAttribute("toeic", toeic);
        request.setAttribute("message", message);

        RequestDispatcher req = request.getRequestDispatcher("display.jsp");
        req.forward(request, response);
    }
}
