package org.example.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MobilePhone")
public class Phone {
    public Phone(String name, String color, int price, String country, int quantity, Manufacture manufacture) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.country = country;
        this.quantity = quantity;
        this.manufacture = manufacture;
    }

    public void setPhone(Phone phone) {
        this.name = phone.getName();
        this.color = phone.getColor();
        this.price = phone.getPrice();
        this.country = phone.getCountry();
        this.quantity = phone.getQuantity();
        this.manufacture = phone.getManufacture();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @Size(min = 3, max = 128)
    private String name;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private int price;
    @Column
    private String country;
    @Column
    private int quantity;
    @ManyToOne(targetEntity = Manufacture.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

}
