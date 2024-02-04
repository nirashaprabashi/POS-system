package com.example.possystem.controller;

import com.example.possystem.model.Items;
import com.example.possystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Items item) {
        itemService.addItem(item.getItemCode(), item.getCategoryCode(), item.getItemName(), item.getAvailableQuantity(), item.getAddedOn());
        return ResponseEntity.ok("Item added successfully");
    }
}
