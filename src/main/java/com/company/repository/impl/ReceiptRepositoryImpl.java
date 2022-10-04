/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.repository.impl;

import com.company.pojo.Receipt;
import com.company.pojo.Service;
import com.company.pojo.Servicedetail;
import com.company.repository.ReceiptRepository;
import com.company.repository.ServiceDetailRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ServiceDetailRepository serviceDetailRepository;
    @Autowired
    private Environment env;
    @Override
    public boolean receipt(Receipt r, Set<Service> ser) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            session.save(r);
            
         for( Service s : ser ){
            Servicedetail serde = new Servicedetail();
            serde.setIdService(s);
            serde.setIdReceipt(r);
            serde.setPrice(s.getPrice());
            serviceDetailRepository.addServiceDetail(serde);
        }
         
            return true;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
