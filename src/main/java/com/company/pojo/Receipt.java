/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "receipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r"),
    @NamedQuery(name = "Receipt.findById", query = "SELECT r FROM Receipt r WHERE r.id = :id"),
    @NamedQuery(name = "Receipt.findByQuantity", query = "SELECT r FROM Receipt r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "Receipt.findByOrderdate", query = "SELECT r FROM Receipt r WHERE r.orderdate = :orderdate"),
    @NamedQuery(name = "Receipt.findByOrganizationdate", query = "SELECT r FROM Receipt r WHERE r.organizationdate = :organizationdate"),
    @NamedQuery(name = "Receipt.findByTotal", query = "SELECT r FROM Receipt r WHERE r.total = :total"),
    @NamedQuery(name = "Receipt.findByActive", query = "SELECT r FROM Receipt r WHERE r.active = :active")})
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date organizationdate;
    @Column(name = "total")
    private Long total;
    @Size(max = 45)
    @Column(name = "active")
    private String active;
    @OneToMany(mappedBy = "idReceipt")
    private Set<Feedback> feedbackSet;
    @JoinColumn(name = "idLobby", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lobby idLobby;
    @JoinColumn(name = "idMenu", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu idMenu;
    @JoinColumn(name = "idRestaurant", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Restaurant idRestaurant;
    @JoinColumn(name = "idCustomer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idCustomer;
    @OneToMany(mappedBy = "idReceipt")
    private Set<Servicedetail> servicedetailSet;

    public Receipt() {
    }

    public Receipt(Integer id) {
        this.id = id;
    }

    public Receipt(Integer id, Date orderdate, Date organizationdate) {
        this.id = id;
        this.orderdate = orderdate;
        this.organizationdate = organizationdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getOrganizationdate() {
        return organizationdate;
    }

    public void setOrganizationdate(Date organizationdate) {
        this.organizationdate = organizationdate;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public Lobby getIdLobby() {
        return idLobby;
    }

    public void setIdLobby(Lobby idLobby) {
        this.idLobby = idLobby;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Restaurant getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Restaurant idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public User getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(User idCustomer) {
        this.idCustomer = idCustomer;
    }

    @XmlTransient
    public Set<Servicedetail> getServicedetailSet() {
        return servicedetailSet;
    }

    public void setServicedetailSet(Set<Servicedetail> servicedetailSet) {
        this.servicedetailSet = servicedetailSet;
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
        if (!(object instanceof Receipt)) {
            return false;
        }
        Receipt other = (Receipt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.pojo.Receipt[ id=" + id + " ]";
    }
    
}
