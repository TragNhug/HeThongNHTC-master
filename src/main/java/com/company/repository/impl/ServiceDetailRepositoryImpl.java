/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.repository.impl;

import com.company.pojo.Receipt;
import com.company.pojo.Service;
import com.company.pojo.Servicedetail;
import com.company.repository.ServiceDetailRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class ServiceDetailRepositoryImpl implements ServiceDetailRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
     
     

    @Override
    public boolean addServiceDetail(Servicedetail ser) {
         try {
             
            Session session = this.sessionFactory.getObject().getCurrentSession(); 
            session.save(ser);
            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
