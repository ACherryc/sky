/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.controller;

import com.example.dinemaster.model.Restaurant;

import com.example.dinemaster.model.Chef;
import com.example.dinemaster.service.RestaurantJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ChefController {
    @Autowired
    public RestaurantJpaService restaurantJpaService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantJpaService.getRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantJpaService.getRestaurantById(restaurantId);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantJpaService.addRestaurant(restaurant);

    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant Restaurant) {
        return restaurantJpaService.updateRestaurant(restaurantId, Restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantJpaService.deleteRestaurant(restaurantId);
    }

    @GetMapping("/restaurants/{restaurantId}/chefs")
    public List<Chef> getRestaurantChefs(@PathVariable("restaurantId") int restaurantId) {
        return restaurantJpaService.getRestaurantChefs(restaurantId);
    }

}
