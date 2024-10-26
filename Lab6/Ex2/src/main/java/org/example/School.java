package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class School {
    private Toilet toilet;

    public School() {
        this.toilet = new Toilet();
    }

    public Toilet getToilet() {
        return toilet;
    }

    @Bean(name = "Luxury")
    public Toilet getLuxuryToilet() {
        return new Toilet("Luxury");
    }

    @Bean(name = "Miserable")
    @Scope("prototype")
    public Toilet getMiserableToilet() {
        return new Toilet("Old, Dirty");
    }

    public void setToilet(Toilet toilet) {
        this.toilet = toilet;
    }
}