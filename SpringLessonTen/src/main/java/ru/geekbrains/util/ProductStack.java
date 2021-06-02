package ru.geekbrains.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.geekbrains.models.Product;

@AllArgsConstructor
@Data
public class ProductStack {
    private Product product;
    private int number;

}
