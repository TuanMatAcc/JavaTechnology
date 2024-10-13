package org.example;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

//            String sql = "Create table products (id int primary key , name varchar(30), quantity int, price double)";
//            Statement stmt = (Statement)conn.createStatement();
//            stmt.executeUpdate(sql);
//            stmt.close();
//        jdbc:mysql://localhost:3307?user=root&password=abcd1234
        if(args.length == 0) {
            System.out.println("Please specify the database URL");
            return;
        }
        ProductDAO productDAO = new ProductDAO(args[0]);
        try {
            if(productDAO.Connection() == null) {
                return;
            }
        }
        catch (Exception e) {
            System.out.println("Invalid URL");
            return;
        }
        do {
            showOptions();
        }
        while (executeOption(args[0]));
    }

    public static void showOptions() {
        System.out.println("Please specify an option:");
        System.out.println("1. Read product list");
        System.out.println("2. Read a detail product by id");
        System.out.println("3. Add a new product");
        System.out.println("4. Update a product");
        System.out.println("5. Delete a product by id");
        System.out.println("6. Exit");
    }

    public static boolean executeOption(String url) {
        System.out.println("Enter your option:");
        Scanner indexOpt = new Scanner(System.in);
        int option = indexOpt.nextInt();
        ProductDAO productDAO = new ProductDAO(url);
        switch (option) {
            case 1:
                System.out.println("Your choice: Read product list");
                List<Product> products = productDAO.readAll();
                boolean flag = true;
                for(Product tmp : products) {
                    flag = false;
                    System.out.println(tmp);
                }
                if(flag) {
                    System.out.println("There is no product in the list");
                }
                break;
            case 2:
                System.out.println("Your choice: Read a detail product by id");
                System.out.println("Enter the product id:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                Product prod1 = productDAO.read(id);
                if (prod1 != null) {
                    System.out.println(prod1);
                }
                else {
                    System.out.println("Product not found");
                }
                break;
            case 3:
                System.out.println("Your choice: Add a new product");
                Product product = new Product();
                System.out.println("Enter the product id:");
                Scanner scanner1 = new Scanner(System.in);
                product.setId(scanner1.nextInt());
                scanner1.nextLine();
                System.out.println("Enter the product name:");
                product.setName(scanner1.nextLine());
                System.out.println("Enter new product quantity:");
                String quantity = scanner1.nextLine();
                if(isInteger(quantity)) {
                    product.setQuantity(Integer.parseInt(quantity));
                }
                else {
                    System.out.println("Invalid quantity");
                    break;
                }
                System.out.println("Enter new product price:");
                String price = scanner1.nextLine();
                if(isDouble(price)) {
                    product.setPrice(Double.parseDouble(price));
                }
                else {
                    System.out.println("Invalid Price");
                    break;
                }
                productDAO.add(product);
                break;
            case 4:
                System.out.println("Your choice: Update a product");
                System.out.println("Enter the product id:");
                Scanner scanner2 = new Scanner(System.in);
                int idProd = scanner2.nextInt();
                Product prod = productDAO.read(idProd);
                if (prod != null) {
                    scanner2.nextLine();
                    System.out.println("Enter new product name:");
                    prod.setName(scanner2.nextLine());
                    System.out.println("Enter new product quantity:");
                    String quantity1 = scanner2.nextLine();
                    if(isInteger(quantity1)) {
                        prod.setQuantity(Integer.parseInt(quantity1));
                    }
                    else {
                        System.out.println("Invalid quantity");
                        break;
                    }
                    System.out.println("Enter new product price:");
                    String price1 = scanner2.nextLine();
                    if(isDouble(price1)) {
                        prod.setPrice(Double.parseDouble(price1));
                    }
                    else {
                        System.out.println("Invalid Price");
                        break;
                    }
                    productDAO.update(prod);
                }
                else {
                    System.out.println("Product not found");
                }
                break;
            case 5:
                System.out.println("Your choice: Delete a product by id");
                System.out.println("Enter the product id:");
                Scanner scanner3 = new Scanner(System.in);
                int idProduct = scanner3.nextInt();
                Product product1 = productDAO.read(idProduct);
                if(product1 == null) {
                    System.out.println("Product not found");
                    break;
                }
                productDAO.delete(idProduct);
                break;
            case 6:
                System.out.println("Your choice: Exit");
                return false;
            default:
                System.out.println("Invalid option");
        }
        return true;
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}