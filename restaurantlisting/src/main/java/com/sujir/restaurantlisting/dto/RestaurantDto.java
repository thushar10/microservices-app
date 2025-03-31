package com.sujir.restaurantlisting.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
