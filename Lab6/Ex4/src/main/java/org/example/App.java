package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
//@ComponentScan
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(TextEditor.class);
        TextEditor textEditor = (TextEditor) appContext.getBean("textEditor");
        textEditor.input("Ronaldo SIuuuuuuuu !!ooo!");
        textEditor.save("CR7");
        for(String name : appContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }
}
