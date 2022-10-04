/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.security.core.Transient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "restaurant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restaurant.findAll", query = "SELECT r FROM Restaurant r"),
    @NamedQuery(name = "Restaurant.findById", query = "SELECT r FROM Restaurant r WHERE r.id = :id"),
    @NamedQuery(name = "Restaurant.findByName", query = "SELECT r FROM Restaurant r WHERE r.name = :name"),
    @NamedQuery(name = "Restaurant.findByRoad", query = "SELECT r FROM Restaurant r WHERE r.road = :road"),
    @NamedQuery(name = "Restaurant.findByWard", query = "SELECT r FROM Restaurant r WHERE r.ward = :ward"),
    @NamedQuery(name = "Restaurant.findByDistrict", query = "SELECT r FROM Restaurant r WHERE r.district = :district"),
    @NamedQuery(name = "Restaurant.findByHotline", query = "SELECT r FROM Restaurant r WHERE r.hotline = :hotline"),
    @NamedQuery(name = "Restaurant.findByStatus", query = "SELECT r FROM Restaurant r WHERE r.status = :status"),
    @NamedQuery(name = "Restaurant.findByImage", query = "SELECT r FROM Restaurant r WHERE r.image = :image")})
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "road")
    private String road;
    @Size(max = 45)
    @Column(name = "ward")
    private String ward;
    @Size(max = 45)
    @Column(name = "district")
    private String district;
    @Size(max = 45)
    @Column(name = "hotline")
    private String hotline;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "idRestaurant")
    @JsonIgnore
    private Set<Lobby> lobbySet;
    @OneToMany(mappedBy = "idRestaurant")
     @JsonIgnore
    private Set<Service> serviceSet;
    @JoinColumn(name = "idOwner", referencedColumnName = "id")
    @ManyToOne
    private User idOwner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestaurant")
    @JsonIgnore

    private Set<Receipt> receiptSet;
    @OneToMany(mappedBy = "idRestaurant")
     @JsonIgnore
    private Set<Menu> menuSet;

    public Restaurant() {
    }

    public Restaurant(Integer id) {
        this.id = id;
    }

    public Restaurant(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<Lobby> getLobbySet() {
        return lobbySet;
    }

    public void setLobbySet(Set<Lobby> lobbySet) {
        this.lobbySet = lobbySet;
    }

    @XmlTransient
    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }

    public User getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(User idOwner) {
        this.idOwner = idOwner;
    }

    @XmlTransient
    public Set<Receipt> getReceiptSet() {
        return receiptSet;
    }

    public void setReceiptSet(Set<Receipt> receiptSet) {
        this.receiptSet = receiptSet;
    }

    @XmlTransient
    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
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
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.pojo.Restaurant[ id=" + id + " ]";
    }
    
}
