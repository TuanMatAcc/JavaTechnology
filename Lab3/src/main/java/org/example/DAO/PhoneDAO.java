package org.example.DAO;

import org.example.pojo.Manufacture;
import org.example.pojo.Phone;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PhoneDAO implements Repository<Phone> {
    public PhoneDAO() {
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
    public boolean add(Phone phone) {
        try {
            Session session = getConnection();
            phone = session.merge(phone);
            session.persist(phone);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean update(Phone phone) {
        try {
            Session session = getConnection();
            session.merge(phone);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean removeByID(int id) {
        if(id < 0) {
            return false;
        }
        try {
            Session session = getConnection();
            Phone p = session.find(Phone.class, id);
            session.remove(p);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean remove(Phone phone) {
        if(phone.getId() < 0) {
            return false;
        }
        try {
            Session session = getConnection();
            Phone p = session.find(Phone.class, phone.getId());
            session.remove(p);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public Phone get(int id) {
        Phone phone = null;
        try {
            Session session = getConnection();

            phone = session.find(Phone.class, id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return phone;
        }
        return phone;
    }
    public List<Phone> getAll() {
        List<Phone> lst = new ArrayList<>();
        try {
            Session session = getConnection();
            lst = session.createQuery("FROM Phone", Phone.class).list();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return lst;
        }
        return lst;
    }

    public Phone getHighestPrice() {
        Phone phone = null;
        try {
            Session session = getConnection();
            String hql = "From Phone where price = (Select max(price) From Phone)";
            phone = session.createQuery(hql, Phone.class).list().getFirst();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return phone;
        }
        return phone;

    }

    public List<Phone> getSortedListByCountryPrice() {
        List<Phone> lst = null;
        try {
            Session session = getConnection();
            String hql = "From Phone order by country asc ,price desc";
            lst = session.createQuery(hql, Phone.class).list();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return lst;
        }
        return lst;
    }

    public boolean existsPhoneGreater50M() {
        Integer p = null;
        try {
            Session session = getConnection();
            String hql = "select max(price) from Phone ";
            p = session.createQuery(hql, Integer.class).list().getFirst();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return p > 50000000;
    }

    public Phone getPinkAndGreater15M() {
        Phone phone = null;
        try {
            Session session = getConnection();
            String hql = "from Phone where color = 'Pink' and price > 15000000";
            phone = session.createQuery(hql, Phone.class).list().getFirst();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return phone;
        }
        return phone;
    }
}
