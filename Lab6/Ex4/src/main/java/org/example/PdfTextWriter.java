package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class PdfTextWriter implements TextWriter{
    public void write(String fileName, String text) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("PDF text: \n"+ text);
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
