package com.sujir.order.service;

import com.sujir.order.dto.*;
import com.sujir.order.entity.Order;
import com.sujir.order.mapper.OrderMapper;
import com.sujir.order.repo.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private final OrderMapper orderMapper;
    private final SequenceGenerator sequenceGenerator;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate,  OrderMapper orderMapper, SequenceGenerator sequenceGenerator) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        this.orderMapper = orderMapper;
        this.sequenceGenerator = sequenceGenerator;
    }


    public OrderDto saveOrder(OrderDtoFE orderDtoFE) {
        //int restaurantId = orderDtoFE.getRestaurant().getId();
        int userId = orderDtoFE.getUserId();
        //boolean isRestaurantValid = validateRestaurant(restaurantId);
        //boolean isFoodItemsValid = validateFoodItems(restaurantId, orderDtoFE.getFoodItemDtoList());

        int orderId = sequenceGenerator.generateNextOrderId();

        UserDto userDto = fetchUserDto(userId);

        Order order = new Order();
        order.setOrderId(orderId);
        order.setFoodItemDtoList(orderDtoFE.getFoodItemDtoList());
        order.setUserDto(userDto);
        order.setRestaurant(orderDtoFE.getRestaurant());

        Order orderSaved = orderRepository.save(order);

        return orderMapper.mapOrderToOrderDto(orderSaved);


    }

    private boolean validateRestaurant(int restaurantId) {
        Restaurant restaurant = fetchRestaurantById(restaurantId);
        return restaurant != null;
    }

    private boolean validateFoodItems(int restaurantId, List<FoodItemDto> foodItemDtoListReq) {
        FoodCataloguePage foodCataloguePage = fetchFoodItems(restaurantId);
        List<FoodItemDto> foodItemList =  foodCataloguePage.getFoodItemList();


        long count = foodItemList.stream().map(foodItemDto -> foodItemDtoListReq.stream().filter(foodItemDto1 ->
                        foodItemDto.getItemName().equals(foodItemDto1.getItemName())).findFirst())
                .count();

        return count == foodItemList.size();
    }

    public Restaurant fetchRestaurantById(int restaurantId) {
        String url = "http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId;
        ResponseEntity<Restaurant> response = restTemplate.getForEntity(url, Restaurant.class);
        return response.getBody();
    }

    public FoodCataloguePage fetchFoodItems(int restaurantId) {
        String url = "http://FOOD-CATALOGUE-SERVICE/foodCatalogue/fetchRestaurantAndFoodItemById/" + restaurantId;
        ResponseEntity<FoodCataloguePage> response = restTemplate.getForEntity(url, FoodCataloguePage.class);
        return response.getBody();
    }

    public UserDto fetchUserDto(int userId) {
        String url = "http://USER-SERVICE/user/fetchUserById/" + userId;
        ResponseEntity<UserDto> response = restTemplate.getForEntity(url, UserDto.class);
        return response.getBody();
    }
}
