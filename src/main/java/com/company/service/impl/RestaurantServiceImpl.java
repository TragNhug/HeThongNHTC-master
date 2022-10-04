/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.pojo.Restaurant;
import com.company.repository.RestaurantRepository;
import com.company.service.RestaurantService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{

     @Autowired
    private RestaurantRepository restaurantRepository;

    
    @Override
    public List<Restaurant> getRestaurants(Map<String, String> params, int page) {
        return this.restaurantRepository.getRestaurants(params, page);
    }

    @Override
    public int countRestaurant() {
        return this.restaurantRepository.countRestaurant();

    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return this.restaurantRepository.getRestaurantById(id);
    }
    
}
