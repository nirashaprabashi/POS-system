package com.example.possystem.controller;

import com.example.possystem.model.ItemCategory;
import com.example.possystem.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;


    @PostMapping("/add")
    public ResponseEntity<String> addItemCategory(@RequestBody ItemCategory itemCategory) {
        itemCategoryService.addItemCategory(itemCategory.getCategoryCode(), itemCategory.getCategory());
        return ResponseEntity.ok("Category added successfully");
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/list")
    public List<ItemCategory> getAllCategories() {
        return itemCategoryService.getAllCategories();
    }
}
