package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ann = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        TextEditor txtEdit = (TextEditor) ann.getBean("getTextEditor");
        txtEdit.input("Đây là Rap Việt !!!!!");
        txtEdit.save("yeahYeah");
    }
}
