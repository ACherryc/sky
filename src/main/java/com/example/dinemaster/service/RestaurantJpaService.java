/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.dinemaster.service;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.model.Chef;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;
import com.example.dinemaster.repository.ChefJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;
    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantJpaRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        try {
            return restaurantJpaRepository.findById(restaurantId).get();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantJpaRepository.save(restaurant);

    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        try {
            Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
            if (restaurant.getName() != null) {
                newRestaurant.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                newRestaurant.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                newRestaurant.setCuisineType(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                newRestaurant.setRating(restaurant.getRating());
            }

            return restaurantJpaRepository.save(newRestaurant);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        try {
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            List<Chef> chefs = chefJpaRepository.findByRestaurant(restaurant);
            for (Chef chef : chefs) {
                chef.setRestaurant(null);
            }
            chefJpaRepository.saveAll(chefs);
            restaurantJpaRepository.deleteById(restaurantId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Chef> getRestaurantChefs(int restaurantId) {
        try {
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            return chefJpaRepository.findByRestaurant(restaurant);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
