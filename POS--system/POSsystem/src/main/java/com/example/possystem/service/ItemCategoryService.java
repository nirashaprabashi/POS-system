package com.example.possystem.service;

import com.example.possystem.model.ItemCategory;
import com.example.possystem.repository.ItemCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryRepo itemCategoryRepo;

    @Transactional
    public void addItemCategory(String categoryCode, String category) {
        itemCategoryRepo.insertItemCategory(categoryCode, category);
    }

    public List<ItemCategory> getAllCategories() {
        return itemCategoryRepo.getAllCategories();
    }
}
