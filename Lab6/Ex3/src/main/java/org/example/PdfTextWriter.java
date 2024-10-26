package org.example;

import java.io.FileWriter;
import java.io.IOException;

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
