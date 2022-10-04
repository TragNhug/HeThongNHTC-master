/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;


import com.company.pojo.Menu;
import com.company.repository.MenuRepository;
import com.company.service.MenuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    

    @Override
    public List<Menu> getMenus(Map<String, String> params, int page, int id) {
        return this.menuRepository.getMenus(params, page, id);
    }
    
    @Override
    public int countMenu(int id) {
        return this.menuRepository.countMenu(id);
    }

    @Override
    public boolean addMenu(Menu m) {
        m.setImage("https://innhanh24h.net/wp-content/uploads/2018/07/Thuc-don-nha-hang-tiec-cuoi-2.png");

        return this.menuRepository.addMenu(m);
    }
    @Override
    public boolean deleteMenu(int id) {
        return this.menuRepository.deleteMenu(id);
    }

    @Override
    public Menu getMenuById(int id) {
        return this.menuRepository.getMenuById(id);
    }
    
}
