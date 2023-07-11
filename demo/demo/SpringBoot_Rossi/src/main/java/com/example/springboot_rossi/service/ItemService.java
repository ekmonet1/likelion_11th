package com.example.springboot_rossi.service;

import com.example.springboot_rossi.domain.Item;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ItemService {
    @Transactional
    public Item save(Item item);

    @Transactional(readOnly = true)
    public List<Item> findAll();

    @Transactional(readOnly = true)
    public Item findById(Long id);
    @Transactional
    public void update(Long id, Item item);
}