/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.repository;


import com.company.pojo.Menu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface MenuRepository {
    List<Menu> getMenus(Map<String, String> params, int page, int id);
    int countMenu(int id);
    boolean addMenu(Menu m);
    boolean deleteMenu(int id);
    Menu getMenuById(int id);
}
