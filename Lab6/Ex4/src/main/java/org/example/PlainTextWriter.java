package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
@Component
public class PlainTextWriter implements TextWriter{
    public void write(String fileName, String text) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("Plain text: \n"+ text);
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
