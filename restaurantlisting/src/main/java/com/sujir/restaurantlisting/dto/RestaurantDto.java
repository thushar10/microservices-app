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

//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//
//    public String getRestaurantDescription() {
//        return restaurantDescription;
//    }
//
//    public void setRestaurantDescription(String restaurantDescription) {
//        this.restaurantDescription = restaurantDescription;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
