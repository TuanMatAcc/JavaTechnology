package org.example.DAO;

import org.example.CustomException.InvalidOperationException;
import org.example.pojo.Manufacture;
import org.example.util.HibernateUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ManufactureDAO implements Repository<Manufacture> {

    public ManufactureDAO() {
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
    public boolean add(Manufacture manufacture) {
        try {
            Session session = getConnection();
            manufacture = session.merge(manufacture);
            session.persist(manufacture);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean update(Manufacture manufacture) {
        try {
            Session session = getConnection();
            session.merge(manufacture);
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
            Manufacture m = session.find(Manufacture.class, id);
            session.remove(m);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public boolean remove(Manufacture manufacture) {
        if(manufacture.getId() < 0) {
            return false;
        }
        try {
            Session session = getConnection();
            Manufacture m = session.find(Manufacture.class, manufacture.getId());
            session.remove(m);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public Manufacture get(int id) {
        Manufacture manufacture = null;
        try {
            Session session = getConnection();

            manufacture = session.find(Manufacture.class, id);

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return manufacture;
        }
        return manufacture;
    }
    public List<Manufacture> getAll() {
        List<Manufacture> lst = new ArrayList<>();
        try {
            Session session = getConnection();
            lst = session.createQuery("FROM Manufacture", Manufacture.class).list();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return lst;
        }
        return lst;
    }

    public boolean isAllMoreThan100Employees() {
        List<Integer> numEmployees;
        try {
            Session session = getConnection();
            numEmployees = session.createQuery("select employee from Manufacture where employee <= 100", Integer.class).list();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return numEmployees.isEmpty();
    }

    public Long getTotalEmployee() {
        Long allEmployees = -1L;
        try {
            Session session = getConnection();
            allEmployees = (Long)session.createQuery("select sum(employee) from Manufacture").list().getFirst();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return allEmployees;
        }
        return allEmployees;
    }

    public Manufacture getLastUSManufacture() throws InvalidOperationException {
        List<Manufacture> lastUSManufactures = null;
        try {
            Session session = getConnection();
            lastUSManufactures = session.createQuery("from Manufacture where location = 'US'", Manufacture.class).list();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        if(lastUSManufactures.isEmpty()) {
            throw new InvalidOperationException("There is no producer based in US") ;
        }
        return lastUSManufactures.getLast();
    }
}
