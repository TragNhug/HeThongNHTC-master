/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service;

import com.company.pojo.Bill;
import com.company.pojo.User;

/**
 *
 * @author HP
 */

public interface ReceiptService {
    
    public boolean addReceipt(Bill b,User u);
            
}
