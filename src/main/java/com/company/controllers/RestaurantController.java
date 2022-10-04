/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controllers;

import com.company.service.LobbyService;
import com.company.service.MenuService;
import com.company.service.RestaurantService;
import com.company.service.ServiceService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice   //để các controller khác thấy
@PropertySource("classpath:messages.properties")
public class RestaurantController {
        
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private LobbyService lobbyService;
     @Autowired
    private MenuService menuService;
      @Autowired
    private ServiceService serviceService;
    @Autowired
    private Environment env;
//    @RequestMapping("/")
//    public String restaurant(){
//        
//        return "index"; //trả về jsp
//    }
    
    
    @RequestMapping("/")
    public String restaurant(Model model, @RequestParam Map<String, String> params){
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("restaurants", this.restaurantService.getRestaurants(params, page));
        model.addAttribute("restaurantCounter", this.restaurantService.countRestaurant());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "restaurant"; //trả về jsp
    }
//    xem chi tiet nha hang
    //xem chi tiết sản phẩm
    @GetMapping("/restaurant/{restaurantId}")
    public String productDetails(Model model,   
        @PathVariable(value = "restaurantId") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("lobbies", this.lobbyService.getLobbies(params, page, id));
        //model.addAttribute("lobbyCounter", this.lobbyService.countLobby());
        model.addAttribute("menus", this.menuService.getMenus(params, page, id));
        model.addAttribute("services", this.serviceService.getServices(params, page,id));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "restaurantDetails";
    }
    //sảnh
    @GetMapping("/restaurant/{restaurantId}/lobby")
    public String lobby(Model model,  
        @PathVariable(value = "restaurantId") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("restaurantId", id);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("lobbies", this.lobbyService.getLobbies(params, page, id));
        model.addAttribute("lobbyCounter", this.lobbyService.countLobby(id));
//        model.addAttribute("menus", this.menuService.getMenus(params, page, id));
//        model.addAttribute("services", this.serviceService.getServices(params, page,id));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "lobby";
    }
    //menu
    @GetMapping("/restaurant/{restaurantId}/menu")
    public String menu(Model model,   
        @PathVariable(value = "restaurantId") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("restaurantId", id);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("lobbies", this.lobbyService.getLobbies(params, page, id));
//        model.addAttribute("lobbyCounter", this.lobbyService.countLobby());
        model.addAttribute("menus", this.menuService.getMenus(params, page, id));
         model.addAttribute("menuCounter", this.menuService.countMenu(id));
//        model.addAttribute("services", this.serviceService.getServices(params, page,id));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "menu";
    }
    @GetMapping("/restaurant/{restaurantId}/service")
    public String service(Model model,   
        @PathVariable(value = "restaurantId") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("restaurantId", id);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        model.addAttribute("lobbies", this.lobbyService.getLobbies(params, page, id));
//        model.addAttribute("lobbyCounter", this.lobbyService.countLobby());
//        model.addAttribute("menus", this.menuService.getMenus(params, page, id));
        model.addAttribute("services", this.serviceService.getServices(params, page,id));
        model.addAttribute("serviceCounter", this.serviceService.countService(id));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        return "service";
    }
     

}
