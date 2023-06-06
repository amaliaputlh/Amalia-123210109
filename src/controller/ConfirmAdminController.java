/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RenterImpl;
import java.sql.SQLException;
import view.ConfirmAdminPage;

/**
 *
 * @author msi-modern
 */
public class ConfirmAdminController {
    ConfirmAdminPage cpa;

    public ConfirmAdminController(ConfirmAdminPage cpa) {
        this.cpa = cpa;
    }
    
    public void confirmPay() throws SQLException {
        String id = cpa.getId().getText();
        RenterImpl rti = new RenterImpl();
        rti.update(id);
        cpa.dispose();
    }
}
