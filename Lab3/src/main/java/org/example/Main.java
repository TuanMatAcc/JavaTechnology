package org.example;

import org.example.CustomException.InvalidOperationException;
import org.example.DAO.ManufactureDAO;
import org.example.DAO.PhoneDAO;
import org.example.pojo.Manufacture;
import org.example.pojo.Phone;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ManufactureDAO manufactureDAO = new ManufactureDAO();
        PhoneDAO phoneDAO = new PhoneDAO();

        // Get the manufacture and reattach it

        Manufacture manufacture = new Manufacture("Apple", "US", 101, new ArrayList<>());
        Manufacture manufacture1 = new Manufacture("Apple", "U", 140, new ArrayList<>());
        Manufacture manufacture2 = new Manufacture("Apple", "S", 120, new ArrayList<>());
        manufactureDAO.add(manufacture);
        manufactureDAO.add(manufacture1);
        manufactureDAO.add(manufacture2);
        // Create a phone and associate it with the managed manufacture entity
        Phone phone = new Phone("Iphone 13", "Pink", 14999999, "USA", 100, manufactureDAO.get(2));
        Phone phone1 = new Phone("Iphone 16", "Pink", 1003993930, "USA", 100, manufactureDAO.get(2));
        Phone phone2 = new Phone("Iphone 14", "Black", 2000, "Angola", 100, manufactureDAO.get(2));
        Phone phone3 = new Phone("Iphone 15", "Pink", 50000001, "Angola", 100, manufactureDAO.get(2));
        phoneDAO.add(phone);
        phoneDAO.add(phone1);
        phoneDAO.add(phone2);
        phoneDAO.add(phone3);
        try {
            System.out.println(manufactureDAO.getLastUSManufacture());
        }
        catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}

