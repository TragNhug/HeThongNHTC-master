/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.controllers;

import com.company.pojo.Bill;
import com.company.pojo.User;
import com.company.service.ReceiptService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
public class ReceiptController {
    
    @Autowired
    ReceiptService receiptService;
    
    
   @PostMapping("/receipt")
    public String receipt(HttpSession session){
        
        User u = (User) session.getAttribute("currentUser");
        Bill b = (Bill) session.getAttribute("bill");
                                  System.out.println("Lop Controller");

        if(receiptService.addReceipt(b,u))
            return "stats";
        return "cart";
            
        
    }
            
    
    
}
