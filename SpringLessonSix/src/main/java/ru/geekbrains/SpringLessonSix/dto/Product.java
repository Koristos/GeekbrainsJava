package ru.geekbrains.SpringLessonSix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @EmbeddedId
    private ProductId productId;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders",
            joinColumns = {
                    @JoinColumn(name = "product_id"),
                    @JoinColumn(name = "product_version")},
            inverseJoinColumns =@JoinColumn(name = "person_id")
    )
    private List<Person> personList;


    @Override
    public String toString() {
        String result = String.format("%1s (id= %2d-%3d) price - %4f",
                this.name, this.productId.getId(), this.productId.getVersion(), this.price);
        return result;
    }

    public String getInfo(){
        String result = String.format("Product - %1s \nCurrent price: %2f \n Ordered by %3s",
                this.name, this.price, Arrays.toString(personList.toArray()));
        return result;
    }





}
