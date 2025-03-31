package com.sujir.foodcatalogue.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {

    private int id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private BigDecimal price;
    private Integer restaurantId;
    private int quantity;

}
