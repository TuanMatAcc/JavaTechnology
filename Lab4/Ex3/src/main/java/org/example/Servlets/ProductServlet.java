package org.example.Servlets;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.POJO.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private Gson gson = new Gson();
    private List<Product> lstProd;
    private int code;
    public ProductServlet() {
        lstProd = new ArrayList<>();
        lstProd.add(new Product(1, "Iphone", 2000));
        lstProd.add(new Product(2, "Samsung Galaxy A7", 900));
        lstProd.add(new Product(3, "Nokia 1280", 9999));
        lstProd.add(new Product(4, "Blackberry", 1000));
        lstProd.add(new Product(5, "Huawei", 1234));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Product prod;
        try {
            if(request.getParameter("id") == null) {
                code = 0;
                String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code) + "\"\n\"data\": " + this.gson.toJson(lstProd);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(productJsonString);
                out.flush();
            }
            else if((prod = getProductByID(Integer.parseInt(request.getParameter("id")))) == null) {
                code = 2;
                String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code) + request.getParameter("id") + "\"";
                response.getWriter().print(productJsonString);
            }
            else {
                code = 0;
                String productJsonString = "\"code\": " + code + ",\n\"message\": \"" + getMessage(code) + "\"\n\"data\": " + this.gson.toJson(prod);
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(productJsonString);
                out.flush();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            int id;
            try {
                if(request.getParameter("id") != null) {
                    id = Integer.parseInt(request.getParameter("id"));
                }
                else {
                    response.getWriter().print("Parameter id not found");
                    return;
                }
            }
            catch (NumberFormatException n) {
                response.getWriter().write("Please enter integer for id");
                return;
            }
            String name = request.getParameter("name");
            if(name == null) {
                response.getWriter().write("Parameter name not found");
                return;
            }
            double price;
            try {
                price = Double.parseDouble(request.getParameter("price"));
            }
            catch (NumberFormatException n) {
                response.getWriter().write("Please enter number for price");
                return;
            }
            catch (NullPointerException nu) {
                response.getWriter().write("Parameter price not found");
                return;
            }
            if(getProductByID(id) != null) {
                code = 6;
                String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code) + '"';
                response.getWriter().print(productJsonString);
            }
            else {
                lstProd.add(new Product(id, name, price));
                code = 3;
                String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code);
                response.getWriter().print(productJsonString);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        int id;
        double price;
        if(request.getParameter("id") == null || request.getParameter("name") == null || request.getParameter("price") == null) {
            response.getWriter().write("Please fully insert parameters");
            return;
        }
        try {
            id = Integer.parseInt(request.getParameter("id"));
            price = Double.parseDouble(request.getParameter("price"));
        }
        catch (NumberFormatException n) {
            response.getWriter().write("Please enter number for price and id");
            return;
        }

        String name = request.getParameter("name");

        Product prod = getProductByID(id);
        if(prod == null) {
            code = 2;
            String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code) + id + "\"";
            response.getWriter().print(productJsonString);
        }
        else {
            prod.setName(name);
            prod.setPrice(price);
            code = 4;
            String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code);
            response.getWriter().print(productJsonString);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        int id;
        if(request.getParameter("id") == null) {
            response.getWriter().write("Please insert id");
            return;
        }
        try {
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch (NumberFormatException n) {
            response.getWriter().write("Please enter number for id");
            return;
        }

        Product prod = getProductByID(id);
        if(prod == null) {
            code = 2;
            String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code) + id + "\"";
            response.getWriter().print(productJsonString);
        }
        else {
            lstProd.remove(prod);
            code = 5;
            String productJsonString = "\"code\": " + code + "\n\"message\": \"" + getMessage(code);
            response.getWriter().print(productJsonString);
        }
    }

    private String getMessage(int code) {
        if(code == 0) {
            return "Đọc sản phẩm thành công";
        }
        else if(code == 2) {
            return "Không tìm thấy sản phẩm với mã số ";
        } else if (code == 3) {
            return "Thêm sản phẩm thành công";
        } else if (code == 4) {
            return "Sửa sản phẩm thành công";
        }
        else if(code == 5) {
            return "Xóa sản phẩm thành công";
        }
        else if(code == 6) {
            return "Mã số đã bị trùng với sản phẩm có sẵn";
        }

        return "";
    }

    private Product getProductByID(int id) {
        for(Product prod : lstProd) {
            if(prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }
}
