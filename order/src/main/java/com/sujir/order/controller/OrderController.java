package com.sujir.order.controller;

import com.sujir.order.dto.OrderDto;
import com.sujir.order.dto.OrderDtoFE;
import com.sujir.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private  final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFE orderDtoFE) {
        OrderDto orderDtoRes =  orderService.saveOrder(orderDtoFE);

        return new ResponseEntity<>(orderDtoRes, HttpStatus.CREATED);

    }
}
