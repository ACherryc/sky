/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.dinemaster.repository;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.model.Chef;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChefJpaRepository extends JpaRepository<Chef, Integer> {
    List<Chef> findByRestaurant(Restaurant restaurant);
}
