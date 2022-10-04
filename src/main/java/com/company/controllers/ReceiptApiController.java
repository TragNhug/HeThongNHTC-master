/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controllers;

import com.company.pojo.Bill;
import com.company.pojo.Service;
import com.company.service.LobbyService;
import com.company.service.MenuService;
import com.company.service.ServiceService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
public class ReceiptApiController {

    
    @Autowired
    LobbyService lobbyService;
    
    @Autowired
    MenuService menuService;
    
    @Autowired
    ServiceService serviceService; 
    
    @GetMapping(value = "/api/addCart/{idRes}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> addCart(@PathVariable(value = "id") String id, @PathVariable(value = "idRes") int idRes, HttpSession session) {
        Bill b = (Bill) session.getAttribute("bill");
        if (b == null) {
            b = new Bill();
        } else {
            if(idRes != b.getIdRes())
                b = new Bill();
        }        
       int ma = Integer.parseInt(id.substring(1));
       b.setIdRes(idRes);
        if (id.contains("L")) {     
           b.setLobby(lobbyService.getLobbyById(ma));    
                
        }
        else if(id.contains("M"))
        {
            b.setMenu(menuService.getMenuById(ma));
        }
        else if(id.contains("S"))
        {
            Service s = serviceService.getServiceById(ma);
            
            Set<Service> listS;
            if(b.getSer() != null){
               listS = b.getSer();
            }
            else
                listS = new HashSet<>();
            
            listS.add(s);
            b.setSer(listS);
        }
        
        
        session.setAttribute("bill", b);
        return new ResponseEntity<>(b,HttpStatus.OK);    

    }
    
    
    @GetMapping(value = "/api/getBill",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> getBill( HttpSession session) {
          Bill b = (Bill) session.getAttribute("bill");
        return new ResponseEntity<>(b,HttpStatus.OK);    

    }
    
    
    
    
}
