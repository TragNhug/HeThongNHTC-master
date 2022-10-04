/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.service;

import com.company.pojo.Lobby;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface LobbyService {
    List<Lobby> getLobbies(Map<String, String> params, int page, int id);
    int countLobby(int id);
    boolean addLobby(Lobby l);
    boolean deleteLobby(int id);
    Lobby getLobbyById(int id);
    Boolean updateLobby(Lobby l);
}
