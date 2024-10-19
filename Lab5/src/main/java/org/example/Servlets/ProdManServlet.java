package org.example.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DAO.ProductDAO;
import org.example.POJO.Account;
import org.example.POJO.Product;

import java.io.IOException;

@WebServlet("/prodman")
public class ProdManServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        request.setAttribute("products", productDAO.getAll());
        Account acc = (Account) request.getSession().getAttribute("user");
        request.setAttribute("user", acc.getUsername());
        request.getRequestDispatcher("/prodman.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("remove")) {
            ProductDAO productDAO = new ProductDAO();
            productDAO.remove(Integer.parseInt(request.getParameter("id")));
        }
        else {
            String name = request.getParameter("name");
            String price = request.getParameter("price");
            if(name == null || name.isEmpty() || price == null || price.isEmpty()) {
                request.getSession().setAttribute("flashMessage", "Name and price are required");
            }
            else {
                ProductDAO productDAO = new ProductDAO();
                productDAO.add(new Product(name, Double.parseDouble(price)));
            }
        }
        response.sendRedirect("/prodman");
    }
}
