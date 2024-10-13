package org.example.pojo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.geolatte.geom.M;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "phones")
@Entity
@Table(name = "Manufacture")
public class Manufacture {
    public Manufacture(String name, String location, int employee, List<Phone> phones) {
        this.name = name;
        this.location = location;
        this.employee = employee;
        this.phones = phones;
    }

    public void setManufacture(Manufacture manufacture) {
        this.name = manufacture.getName();
        this.location = manufacture.getLocation();
        this.employee = manufacture.getEmployee();
        this.phones = manufacture.getPhones();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 3, max = 128)
    @Column(nullable = false)
    private String name;
    @Column
    private String location;
    @Column
    private int employee;
    @OneToMany(targetEntity = Phone.class,cascade = CascadeType.ALL, mappedBy = "manufacture")
    private List<Phone> phones;
}