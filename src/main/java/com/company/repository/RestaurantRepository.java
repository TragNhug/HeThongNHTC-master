/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.repository;

import com.company.pojo.Restaurant;
import com.company.service.RestaurantService;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */

public interface RestaurantRepository {
    List<Restaurant> getRestaurants(Map<String, String> params, int page);
    int countRestaurant();
    Restaurant getRestaurantById(int id);
}
