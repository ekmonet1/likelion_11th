package com.example.springboot_rossi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue

    private long id;

    private String brand;
    private String name;
    private Integer price;
    private Integer stock;
}
