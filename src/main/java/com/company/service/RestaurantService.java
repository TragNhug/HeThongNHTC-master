/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.service;

import com.company.pojo.Restaurant;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface RestaurantService {
    List<Restaurant> getRestaurants(Map<String, String> params, int page);
    int countRestaurant();
    Restaurant getRestaurantById(int id);
}
