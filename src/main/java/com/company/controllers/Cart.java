/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controllers;

import com.company.pojo.Bill;
import com.company.pojo.Servicedetail;
import com.company.repository.ServiceDetailRepository;
import com.company.service.ReceiptService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author HP
 */
@Controller
public class Cart {
    
    @Autowired
    ServiceDetailRepository serviceDetailRepository; 
    
   
    
    @GetMapping("/cart")
    public String cart(Model model ,HttpSession session){
        Bill b = (Bill) session.getAttribute("bill");
        model.addAttribute("bill",b);       
        return "cart";
    }
            
}
