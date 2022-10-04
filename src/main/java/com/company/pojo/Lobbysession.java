/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "lobbysession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lobbysession.findAll", query = "SELECT l FROM Lobbysession l"),
    @NamedQuery(name = "Lobbysession.findById", query = "SELECT l FROM Lobbysession l WHERE l.id = :id"),
    @NamedQuery(name = "Lobbysession.findByPrice", query = "SELECT l FROM Lobbysession l WHERE l.price = :price"),
    @NamedQuery(name = "Lobbysession.findByDate", query = "SELECT l FROM Lobbysession l WHERE l.date = :date")})
public class Lobbysession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "price")
    private Long price;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "idLobby", referencedColumnName = "id")
    @ManyToOne
    private Lobby idLobby;
    @JoinColumn(name = "idSession", referencedColumnName = "id")
    @ManyToOne
    private Session idSession;

    public Lobbysession() {
    }

    public Lobbysession(Integer id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Lobby getIdLobby() {
        return idLobby;
    }

    public void setIdLobby(Lobby idLobby) {
        this.idLobby = idLobby;
    }

    public Session getIdSession() {
        return idSession;
    }

    public void setIdSession(Session idSession) {
        this.idSession = idSession;
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
        if (!(object instanceof Lobbysession)) {
            return false;
        }
        Lobbysession other = (Lobbysession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.pojo.Lobbysession[ id=" + id + " ]";
    }
    
}
