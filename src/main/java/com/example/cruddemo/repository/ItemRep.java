package com.example.cruddemo.repository;

import com.example.cruddemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRep extends JpaRepository<Item, Long> {
    Item findByName(String name);
}
