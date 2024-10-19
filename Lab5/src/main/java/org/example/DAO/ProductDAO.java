package org.example.DAO;

import org.example.POJO.Product;
import org.example.Util.HibernateUtils;
import org.hibernate.Session;

public class ProductDAO {
    public ProductDAO() {
    }
    public Session getConnection() {
        Session session;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            return session;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void add(Product product) {
        try {
            Session session = getConnection();
            session.persist(product);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product get(int id) {
        Product product = null;
        try {
            Session session = getConnection();
            product = session.find(Product.class, id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public void update(Product product) {
        try {
            Session session = getConnection();
            session.merge(product);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(int id) {
        try {
            Session session = getConnection();
            Product p = session.find(Product.class, id);
            session.remove(p);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Product[] getAll() {
        Product[] products = null;
        try {
            Session session = getConnection();
            products = (Product[]) session.createQuery("FROM Product").list().toArray(new Product[0]);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}
