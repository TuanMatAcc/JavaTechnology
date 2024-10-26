package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public TextWriter getTextPlain() {
        return new PlainTextWriter();
    }

    @Bean
    public TextWriter getPdfWriter() {
        return new PdfTextWriter();
    }

    @Bean
    public TextEditor getTextEditor() {
        return new TextEditor();
    }
}
