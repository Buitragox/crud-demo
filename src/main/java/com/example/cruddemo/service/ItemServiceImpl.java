package com.example.cruddemo.service;

import com.example.cruddemo.entity.Item;
import com.example.cruddemo.repository.ItemRep;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{
    // Item Service Implementation

    @Autowired
    private ItemRep itemRep;

    @Override
    public Item saveItem(Item item) {
        return itemRep.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRep.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        Optional<Item> optionalItemDB = itemRep.findById(itemId);
        return optionalItemDB.orElse(null);
    }

    @Override
    public void deleteItemById(Long itemId) {
        itemRep.deleteById(itemId);
    }

    @Override
    public Item updateItem(Long itemId, @NotNull Item item) {
        Optional<Item> optionalItemDB = itemRep.findById(itemId);
        if (optionalItemDB.isEmpty()) {
            return null;
        }

        Item itemDB = optionalItemDB.get();
        if (Objects.nonNull(item.getName())
                && !item.getName().equalsIgnoreCase("")) {
            itemDB.setName(item.getName());
        }

        if (item.getPrice() >= 0) {
            itemDB.setPrice(item.getPrice());
        }

        if (item.getQuantity() >= 0) {
            itemDB.setQuantity(item.getQuantity());
        }

        return itemRep.save(itemDB);
    }

    @Override
    public Item getItemByName(String itemName) {
        return itemRep.findByName(itemName);
    }

}
