package com.sujir.foodcatalogue.service;

import com.sujir.foodcatalogue.repo.FoodItemRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {

    private final FoodItemRepository foodItemRepository;

    public FoodCatalogueService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

}
