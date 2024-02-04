package com.example.possystem.service;

import com.example.possystem.model.Items;
import com.example.possystem.repository.ItemRepo;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepository;

    @Transactional
    public void addItem(String itemCode, String categoryCode, String itemName, int availableQuantity, LocalDateTime addedOn) {
        itemRepository.insertItem(itemCode, categoryCode, itemName, availableQuantity, addedOn);
    }
}
