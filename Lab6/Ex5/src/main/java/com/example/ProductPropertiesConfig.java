package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
        @PropertySource("application.properties"),
        @PropertySource("*.properties")
})
@ComponentScan
public class ProductPropertiesConfig {
}
