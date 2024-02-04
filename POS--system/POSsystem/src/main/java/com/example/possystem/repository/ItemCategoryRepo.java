package com.example.possystem.repository;

import com.example.possystem.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemCategoryRepo extends JpaRepository<ItemCategory, Long> {
    @Modifying
    @Query(value = "INSERT INTO items_category(category_code, category) VALUES (?1, ?2)", nativeQuery = true)
    void insertItemCategory(String categoryCode, String category);

    @Modifying
    @Query(value = "SELECT * FROM item_category", nativeQuery = true)
    List<ItemCategory> getAllCategories();
}
