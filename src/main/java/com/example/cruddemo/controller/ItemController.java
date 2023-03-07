package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Item;

import com.example.cruddemo.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/items")
    public Item saveItem(@Valid @RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable("id") Long itemId) {
        return itemService.getItemById(itemId);
    }

    @GetMapping("/items/name/{name}")
    public Item getItemByName(@PathVariable("name") String itemName) {
        return itemService.getItemByName(itemName);
    }

    @DeleteMapping("/items/{id}")
    public String deleteItemById(@PathVariable("id") Long itemId) {
        itemService.deleteItemById(itemId);
        return "Deleted";
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable("id") Long itemId,
                           @RequestBody Item item) {
        return itemService.updateItem(itemId, item);
    }


}
