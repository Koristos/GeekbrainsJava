package ru.geekbrains.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPage {
    private List<Product> products;
    private Integer curPage;
    private Integer direction;
}
