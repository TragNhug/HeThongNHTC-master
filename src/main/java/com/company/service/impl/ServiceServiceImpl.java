/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;


import com.company.repository.ServiceRepository;
import com.company.service.ServiceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<com.company.pojo.Service> getServices(Map<String, String> params, int page, int id) {
        return this.serviceRepository.getServices(params, page, id);
    }
    @Override
    public int countService(int id) {
        return this.serviceRepository.countService(id);
    }

    @Override
    public boolean addService(com.company.pojo.Service s) {
        s.setImage("https://toplist.vn/images/800px/song-anh-wedding-amp-events-436987.jpg");

        return this.serviceRepository.addService(s);
    }

    @Override
    public boolean deleteService(int id) {
        return this.serviceRepository.deleteService(id);
    }

    @Override
    public com.company.pojo.Service getServiceById(int id) {
        return this.serviceRepository.getServiceById(id);
    }
}
