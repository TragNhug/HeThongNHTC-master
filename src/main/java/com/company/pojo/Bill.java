/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.pojo;

import java.util.Set;

/**
 *
 * @author HP
 */
public class Bill {
    
    private int idRes;
    private Lobby lobby;
    private Menu menu;
    private Set<Service> ser;

    /**
     * @return the rece
     */
    public Lobby getLobby() {
        return lobby;
    }

    /**
     * @param rece the rece to set
     */
    public void setLobby(Lobby rece) {
        this.lobby = rece;
    }

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @return the ser
     */
    public Set<Service> getSer() {
        return ser;
    }

    /**
     * @param ser the ser to set
     */
    public void setSer(Set<Service> ser) {
        this.ser = ser;
    }

    /**
     * @return the idRes
     */
    public int getIdRes() {
        return idRes;
    }

    /**
     * @param idRes the idRes to set
     */
    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }
    
    
    
}
