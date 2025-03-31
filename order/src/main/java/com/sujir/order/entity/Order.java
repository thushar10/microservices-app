package com.sujir.order.entity;

import com.sujir.order.dto.FoodItemDto;
import com.sujir.order.dto.Restaurant;
import com.sujir.order.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private UserDto userDto;
    private Restaurant restaurant;
}
