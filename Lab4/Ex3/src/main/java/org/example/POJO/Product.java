package org.example.POJO;

public class Product {
    private int id;         // Product ID
    private String name;    // Product Name
    private double price;    // Product Price

    // Constructor to initialize product details
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n{" +
                "\"id\": " + id +
                ",\n\"name\": \"" + name + '"' +
                ",\n\"price\": " + price +
                "}";
    }
}

