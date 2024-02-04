package com.example.possystem.repository;

import com.example.possystem.model.Items;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ItemRepo extends JpaRepository<Items, Integer> {
    @Modifying
    @Query(value = "INSERT INTO items(item_code, category_code, item_name, available_quantity, added_on) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
    void insertItem(String itemCode, String categoryCode, String itemName, int availableQuantity, LocalDateTime addedOn);
}
