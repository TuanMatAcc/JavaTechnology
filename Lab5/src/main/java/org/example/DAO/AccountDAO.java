package org.example.DAO;

import org.example.POJO.Account;
import org.hibernate.Session;
import org.example.Util.HibernateUtils;

public class AccountDAO {
    public AccountDAO() {
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

    public void add(Account account) {
        try {
            Session session = getConnection();
            session.persist(account);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Account get(String username) {
        Account account = null;
        try {
            Session session = getConnection();
            account = session.find(Account.class, username);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return account;
    }
}
