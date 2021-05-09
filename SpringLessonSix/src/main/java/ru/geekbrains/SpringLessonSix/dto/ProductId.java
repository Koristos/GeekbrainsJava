package ru.geekbrains.SpringLessonSix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductId implements Serializable {

    @Column(name = "id_products")
    private int id;
    @Column(name = "product_version")
    private int version;
}
