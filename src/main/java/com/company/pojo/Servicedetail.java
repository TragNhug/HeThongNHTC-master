/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "servicedetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicedetail.findAll", query = "SELECT s FROM Servicedetail s"),
    @NamedQuery(name = "Servicedetail.findById", query = "SELECT s FROM Servicedetail s WHERE s.id = :id"),
    @NamedQuery(name = "Servicedetail.findByPrice", query = "SELECT s FROM Servicedetail s WHERE s.price = :price")})
public class Servicedetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Long price;
    @JoinColumn(name = "idReceipt", referencedColumnName = "id")
    @ManyToOne
    private Receipt idReceipt;
    @JoinColumn(name = "idService", referencedColumnName = "id")
    @ManyToOne
    private Service idService;

    public Servicedetail() {
    }

    public Servicedetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Receipt getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(Receipt idReceipt) {
        this.idReceipt = idReceipt;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicedetail)) {
            return false;
        }
        Servicedetail other = (Servicedetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.pojo.Servicedetail[ id=" + id + " ]";
    }
    
}
