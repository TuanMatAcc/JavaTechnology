package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ProductDAO implements Repository<Product, Integer> {
    private String connectionUrl;

    public ProductDAO(String connectionUrl) {
        if(connectionUrl == null) {
            System.out.println("Invalid connection URL");
            return;
        }
        this.connectionUrl = connectionUrl;
    }

    public Connection Connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
        }
        catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public boolean checkConnection() {
        Connection conn = Connection();
        if(conn == null) {
            System.out.println("Connection failed");
            return false;
        }
        return true;
    }

    public Integer add(Product item) {
        String sql = "insert into product values(?, ?, ?, ?)";
        try {
            Connection conn = Connection();
            if(!checkConnection()) {
                return null;
            }

            PreparedStatement st =  conn.prepareStatement(sql);
            st.setInt(1, item.getId());
            st.setString(2, item.getName());
            st.setInt(3, item.getQuantity());
            st.setDouble(4, item.getPrice());
            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return item.getId();
    }

    public List<Product> readAll() {
        String sql = "select * from product";
        List<Product> products = new ArrayList<Product>();
        try {
            Connection conn = Connection();
            if(!checkConnection()) {
                return null;
            }
            Statement st = conn.createStatement();
            ResultSet tmp = st.executeQuery(sql);
            while (tmp.next()) {
                Product product = new Product();
                product.setId(tmp.getInt("id"));
                product.setName(tmp.getString("name"));
                product.setQuantity(tmp.getInt("quantity"));
                product.setPrice(tmp.getDouble("price"));
                products.add(product);
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public Product read(Integer id) {
        String sql = "select * from product where id = ?";
        try {
            Connection conn = Connection();
            if(!checkConnection()) {
                return null;
            }

            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet tmp = st.executeQuery();
            if (tmp.next()) {
                Product product = new Product();
                product.setId(tmp.getInt("id"));
                product.setName(tmp.getString("name"));
                product.setQuantity(tmp.getInt("quantity"));
                product.setPrice(tmp.getDouble("price"));
                return product;
            }

            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(Product item) {
        String sql = "update product set name = ?, quantity = ?, price = ? where id = ?";
        try {
            Connection conn = Connection();
            if(!checkConnection()) {
                return false;
            }

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, item.getName());
            st.setInt(2, item.getQuantity());
            st.setDouble(3, item.getPrice());
            st.setInt(4, item.getId());

            st.executeUpdate();

            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean delete(Integer id) {
        String sql = "delete from product where id = ?";
        try {
            Connection conn = Connection();
            if(!checkConnection()) {
                return false;
            }
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

            st.close();
            conn.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
