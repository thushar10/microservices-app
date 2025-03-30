package com.sujir.restaurantlisting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
//@Data

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
