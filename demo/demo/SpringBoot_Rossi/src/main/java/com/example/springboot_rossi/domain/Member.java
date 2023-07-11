package com.example.springboot_rossi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id //pk값
    @GeneratedValue

    private long id;
    private String name;
    private String state;
    private String street;
    private String zipcode;
}