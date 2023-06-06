/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RenterImpl;
import DAO.RoomsImpl;
import java.sql.SQLException;
import model.Renter;
import view.RenterDataView;

/**
 *
 * @author msi-modern
 */
public class RenterDataController {
    RenterImpl renter = new RenterImpl();
    Renter r = new Renter();
    RenterDataView rdv;
    
    public RenterDataController(RenterDataView rdv) {
        this.rdv = rdv;
    }
    
    public void addData()throws SQLException{
        String name = rdv.getTfName().getText();
        String room = rdv.getLroom().getText();
        String contact = rdv.getTfContact().getText();
        int id = Integer.parseInt(rdv.getTfid().getText());
        int rentTime = Integer.parseInt(rdv.getTfRentTime().getText());
        int price = Integer.parseInt(rdv.getLprice().getText());
        int total = price*rentTime;
        String status = "notPaid";
        r.setName(name);
        r.setBill(total);
        r.setContact(contact);
        r.setDuration(rentTime);
        r.setId(id);
        r.setRoom(room);
        r.setStatus(status);
        renter.insert(r);
        RoomsImpl rmi = new RoomsImpl();
        rmi.updateStatus(name, room);
        rdv.dispose();
    }
}
