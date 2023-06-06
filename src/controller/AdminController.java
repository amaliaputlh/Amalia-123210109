/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RenterImpl;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminTabelModel;
import model.Renter;
import view.AdminPageView;

/**
 *
 * @author msi-modern
 */
public class AdminController {
    Renter renter;
    AdminPageView apv;
    RenterImpl rti;
    List<Renter> rts;
    public AdminController(AdminPageView apv) {
        this.apv = apv;
        rti = new RenterImpl();
    }
    
    public void isiTabel() {
        try {
            rts = rti.getAll();
            AdminTabelModel adm = new AdminTabelModel(rts);
            apv.getTabel().setModel(adm);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
