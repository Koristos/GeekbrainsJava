package ru.geekbrains.springlessonfour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    List <Product> cartContent;
    Double total;
    Integer count;
}
