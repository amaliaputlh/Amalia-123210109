/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RoomsImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Rooms;
import model.RoomsTabelModel;
import view.RoomListView;

/**
 *
 * @author msi-modern
 */
public class RoomListController {
    Rooms room;
    RoomListView rlv;
    RoomsImpl rmi;
    List<Rooms> rms;
    public RoomListController(RoomListView rlv) {
        this.rlv = rlv;
        rmi = new RoomsImpl();
    }
    
    public void isiTabel() {
        try {
            rms = rmi.getAll();
            RoomsTabelModel rtm = new RoomsTabelModel(rms);
            rlv.getTabel().setModel(rtm);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
