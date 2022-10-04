/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.repository;

import com.company.pojo.Receipt;
import com.company.pojo.Service;
import com.company.pojo.Servicedetail;
import java.util.List;
import java.util.Set;

/**
 *
 * @author HP
 */
public interface ReceiptRepository {
//    dat hang
    boolean receipt(Receipt r, Set<Service> serde);
    
}
