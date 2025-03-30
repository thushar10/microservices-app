package com.sujir.foodcatalogue.controller;

import com.sujir.foodcatalogue.repo.FoodItemRepository;
import com.sujir.foodcatalogue.service.FoodCatalogueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodcatalogue")
public class FoodCatalogueController {

    private final FoodCatalogueService foodCatalogueService;

    public FoodCatalogueController(FoodCatalogueService foodCatalogueService) {
        this.foodCatalogueService = foodCatalogueService;
    }



}
