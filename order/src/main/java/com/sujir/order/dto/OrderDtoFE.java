package com.sujir.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFE {

    private List<FoodItemDto> foodItemDtoList;
    private Integer userId;
    private Restaurant restaurant;

}
