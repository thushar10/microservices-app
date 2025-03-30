package com.sujir.restaurantlisting.service;

import com.sujir.restaurantlisting.dto.RestaurantDto;
import com.sujir.restaurantlisting.entity.Restaurant;
import com.sujir.restaurantlisting.mapper.RestaurantMapper;
import com.sujir.restaurantlisting.repo.RestaurantRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepo restaurantRepo, RestaurantMapper restaurantMapper) {
        this.restaurantRepo = restaurantRepo;
        this.restaurantMapper = restaurantMapper;
    }


    public List<RestaurantDto> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().map(restaurantMapper::mapRestaurantToRestaurantDto).toList();
    }

    public ResponseEntity<RestaurantDto> fetchById(Integer id) {
        Optional<Restaurant> byId = restaurantRepo.findById(id);
        if(byId.isPresent()) {
            return new ResponseEntity<>(restaurantMapper.mapRestaurantToRestaurantDto(byId.get()), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantMapper.mapRestaurantDTOToRestaurant(restaurantDto);
        Restaurant restaurantEntity = restaurantRepo.save(restaurant);
        return restaurantMapper.mapRestaurantToRestaurantDto(restaurantEntity);
    }
}
