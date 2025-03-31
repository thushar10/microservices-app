package com.sujir.foodcatalogue.controller;

import com.sujir.foodcatalogue.dto.FoodCataloguePage;
import com.sujir.foodcatalogue.dto.FoodItemDto;
import com.sujir.foodcatalogue.repo.FoodItemRepository;
import com.sujir.foodcatalogue.service.FoodCatalogueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;

    public FoodCatalogueController(FoodCatalogueService foodCatalogueService) {
        this.foodCatalogueService = foodCatalogueService;
    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){

        FoodItemDto foodItemDtoRes = foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(foodItemDtoRes, HttpStatus.CREATED);

    }


    @GetMapping("/fetchRestaurantAndFoodItemById/{id}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantAndFoodItemById(@PathVariable("id") Integer id) {
        return foodCatalogueService.fetchRestaurantAndFoodItemById(id);
    }
}
