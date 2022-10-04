/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.pojo.Bill;
import com.company.pojo.Receipt;
import com.company.pojo.Service;
import com.company.pojo.Servicedetail;
import com.company.pojo.User;
import com.company.repository.ReceiptRepository;
import com.company.repository.impl.ReceiptRepositoryImpl;
import com.company.service.ReceiptService;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author HP
 */
@org.springframework.stereotype.Service
public class ReceiptServerImpl implements ReceiptService {

    
    @Autowired
    ReceiptRepository receiptRepository;
    
    @Override
    public boolean addReceipt(Bill b,User u) {
        
        Receipt r = new Receipt();
        r.setIdCustomer(u);
        r.setIdLobby(b.getLobby());
        r.setIdMenu(b.getMenu());
        r.setIdRestaurant(b.getLobby().getIdRestaurant());
        r.setOrderdate(new Date());
        r.setOrganizationdate(new Date());
       
         
        return this.receiptRepository.receipt(r,b.getSer());
        
    }
    
}
