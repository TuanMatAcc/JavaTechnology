package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("appConfig.xml");
        Product product = (Product) appContext.getBean("Product");
        Product product1 = (Product) appContext.getBean("ProductConstructor");
        Product product2 = (Product) appContext.getBean("ProductSingle");
        Product product3 = (Product) appContext.getBean("ProductSingle");
        product3.setPrice(123);
        System.out.println(product);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
    }
}
