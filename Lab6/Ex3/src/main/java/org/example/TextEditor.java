package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
    @Autowired
    @Qualifier("getPdfWriter")
    private TextWriter textWriter;
    private String text;

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        textWriter.write(fileName, text);
    }
}
