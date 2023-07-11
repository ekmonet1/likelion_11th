package com.example.springboot_rossi.repository;

import com.example.springboot_rossi.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item save(Item item);
}