/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.dinemaster.repository;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.model.Chef;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getRestaurants();

    Restaurant getRestaurantById(int restaurantId);

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);

    void deleteRestaurant(int restaurantId);

    List<Chef> getRestaurantChefs(int restaurantId);
}
