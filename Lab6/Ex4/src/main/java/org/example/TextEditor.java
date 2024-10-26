package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class TextEditor {
    @Autowired
    @Qualifier("pdfTextWriter")
    private TextWriter textWriter;
    private String text;

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        textWriter.write(fileName, text);
    }
}
