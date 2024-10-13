package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class LoginServlet extends HttpServlet {
    private HashMap<String, String> accounts;
    public LoginServlet() {
        accounts = new HashMap<String, String>();
        accounts.put("Ronaldo", "Siu123");
        accounts.put("TuanTinhTao", "Tuan123");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("index.jsp");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            if(accounts.get(request.getParameter("username")).equals(request.getParameter("password"))) {
                response.getWriter().write("Successfully Login");
            }
            else {
                response.getWriter().write("Password is wrong");
            }
        }
        catch (NullPointerException ex) {
            try {
                response.getWriter().write("Username is wrong");
            }
            catch (IOException e) {
                System.out.println(ex.getMessage());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}