package com.sujir.foodcatalogue.service;

import com.sujir.foodcatalogue.dto.FoodCataloguePage;
import com.sujir.foodcatalogue.dto.FoodItemDto;
import com.sujir.foodcatalogue.dto.Restaurant;
import com.sujir.foodcatalogue.entity.FoodItem;
import com.sujir.foodcatalogue.mapper.FoodItemMapper;
import com.sujir.foodcatalogue.repo.FoodItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCatalogueService {

    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;
    private final RestTemplate restTemplate;

    public FoodCatalogueService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper, RestTemplate restTemplate) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
        this.restTemplate = restTemplate;
    }


    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItemSaved = foodItemRepository.save(foodItemMapper.mapFoodItemDTOToFoodItem(foodItemDto));
        return foodItemMapper.mapFoodItemToFoodItemDto(foodItemSaved);
    }

    public ResponseEntity<FoodCataloguePage> fetchRestaurantAndFoodItemById(Integer id) {

        Restaurant restaurant = fetchRestaurantById(id);
        List<FoodItem> foodItems = foodItemRepository.findByRestaurantId(id);


        if(restaurant != null) {

            FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
            foodCataloguePage.setFoodItemList(foodItems);
            foodCataloguePage.setRestaurant(restaurant);
            return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

    public Restaurant fetchRestaurantById(int id) {
        String url = "http://RESTAURANT-SERVICE/restaurant/fetchById/" + id;
        ResponseEntity<Restaurant> response = restTemplate.getForEntity(url, Restaurant.class);
        return response.getBody();
    }
}
