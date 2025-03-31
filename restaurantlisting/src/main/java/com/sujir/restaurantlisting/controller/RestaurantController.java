package com.sujir.restaurantlisting.controller;

import com.sujir.restaurantlisting.dto.RestaurantDto;
import com.sujir.restaurantlisting.entity.Restaurant;
import com.sujir.restaurantlisting.service.RestaurantService;
import jakarta.ws.rs.core.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> fetchAllRestaurants() {
        List<RestaurantDto> restaurantDtos = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(restaurantDtos, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        RestaurantDto restaurantDtoRes = restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>(restaurantDtoRes, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDto> fetchById(@PathVariable("id") Integer id) {
        return restaurantService.fetchById(id);
    }
}
