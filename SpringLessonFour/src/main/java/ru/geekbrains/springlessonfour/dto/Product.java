package ru.geekbrains.springlessonfour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;

}


