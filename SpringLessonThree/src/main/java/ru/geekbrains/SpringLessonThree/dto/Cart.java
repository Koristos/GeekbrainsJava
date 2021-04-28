package ru.geekbrains.SpringLessonThree.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
    List <Product> cartContent;
    Double total;
    Integer count;
}
