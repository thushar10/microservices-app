package com.sujir.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private UserDto userDto;
    private Restaurant restaurant;
}
