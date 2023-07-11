package com.example.springboot_rossi.controller;

import com.example.springboot_rossi.domain.Item;
import com.example.springboot_rossi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("items")
public class ItemController {
    public final ItemService ItemService;

    @Autowired
    public ItemController(ItemService ItemService) {
        this.ItemService = ItemService;
    }

    @GetMapping("new")
    public String createForm(Model model) {
        model.addAttribute("itemForm", new Item());
        return "items/createItemForm";
    }

    @PostMapping("new")
    public String create(Item item) {

        ItemService.save(item);
        return "redirect:/";
    }

    @GetMapping("")
    public String findAll(Model model) {
        List<Item> itemList = ItemService.findAll();
        model.addAttribute("itemList", itemList);
        return "items/itemList";
    }
}