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

/**
 *
 * @author HP
 */
@Entity
@Table(name = "lobby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lobby.findAll", query = "SELECT l FROM Lobby l"),
    @NamedQuery(name = "Lobby.findById", query = "SELECT l FROM Lobby l WHERE l.id = :id"),
    @NamedQuery(name = "Lobby.findByName", query = "SELECT l FROM Lobby l WHERE l.name = :name"),
    @NamedQuery(name = "Lobby.findByPrice", query = "SELECT l FROM Lobby l WHERE l.price = :price"),
    @NamedQuery(name = "Lobby.findByQtytable", query = "SELECT l FROM Lobby l WHERE l.qtytable = :qtytable"),
    @NamedQuery(name = "Lobby.findByImage", query = "SELECT l FROM Lobby l WHERE l.image = :image")})
public class Lobby implements Serializable {

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
    @Column(name = "price")
    private Long price;
    @Column(name = "qtytable")
    private Integer qtytable;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "idRestaurant", referencedColumnName = "id")
    @ManyToOne
    private Restaurant idRestaurant;
    @OneToMany(mappedBy = "idLobby")
    @JsonIgnore

    private Set<Lobbysession> lobbysessionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLobby")
    @JsonIgnore

    private Set<Receipt> receiptSet;

    public Lobby() {
    }

    public Lobby(Integer id) {
        this.id = id;
    }

    public Lobby(Integer id, String name) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQtytable() {
        return qtytable;
    }

    public void setQtytable(Integer qtytable) {
        this.qtytable = qtytable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Restaurant idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    @XmlTransient
    public Set<Lobbysession> getLobbysessionSet() {
        return lobbysessionSet;
    }

    public void setLobbysessionSet(Set<Lobbysession> lobbysessionSet) {
        this.lobbysessionSet = lobbysessionSet;
    }

    @XmlTransient
    public Set<Receipt> getReceiptSet() {
        return receiptSet;
    }

    public void setReceiptSet(Set<Receipt> receiptSet) {
        this.receiptSet = receiptSet;
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
        if (!(object instanceof Lobby)) {
            return false;
        }
        Lobby other = (Lobby) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.pojo.Lobby[ id=" + id + " ]";
    }

}
