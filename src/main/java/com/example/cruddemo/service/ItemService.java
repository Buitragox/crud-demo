package com.example.cruddemo.service;

import com.example.cruddemo.entity.Item;

import java.util.List;

public interface ItemService {
    Item saveItem(Item item);

    List<Item> getAllItems();

    Item getItemById(Long itemId);

    void deleteItemById(Long itemId);

    Item updateItem(Long itemId, Item item);

    Item getItemByName(String itemName);
}
