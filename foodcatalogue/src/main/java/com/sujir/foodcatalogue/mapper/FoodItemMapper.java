package com.sujir.foodcatalogue.mapper;

import com.sujir.foodcatalogue.dto.FoodItemDto;
import com.sujir.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FoodItemMapper {
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDto foodItemDto);
    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
}
