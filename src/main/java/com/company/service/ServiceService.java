/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.service;



import com.company.pojo.Service;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface ServiceService {
    List<Service> getServices(Map<String, String> params, int page, int id);
    int countService(int id);
    boolean addService(Service s);
    boolean deleteService(int id);
    Service getServiceById(int id);
    
}
