package ru.geekbrains.SpringLessonSix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persons")
    private int id;
    @Column(name = "person_name")
    private String name;
    @Column (name = "person_mail")
    private String mail;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = {
            @JoinColumn(name = "product_id"),
            @JoinColumn(name = "product_version")
    })

    private List<Product> productList;

    @Override
    public String toString() {
        String result = String.format("%1s (id= %2d)",
                this.name, this.id);
        return result;
    }

    public String getInfo(){
        String result = String.format("Name - %1s \n Mail - %2s \n Ordered products %3s",
                this.name, this.mail, Arrays.toString(productList.toArray()));
        return result;
    }
}
