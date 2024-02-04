package com.example.possystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iditemCode;
    private String itemCode;
    private String categoryCode;
    private String itemName;
    private int availableQuantity;
    private LocalDateTime addedOn;
}
