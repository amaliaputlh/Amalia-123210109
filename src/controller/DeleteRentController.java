/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.RenterImpl;
import java.sql.SQLException;
import view.DeleteRentPage;

/**
 *
 * @author msi-modern
 */
public class DeleteRentController {
    DeleteRentPage drp;

    public DeleteRentController(DeleteRentPage drp) {
        this.drp = drp;
    }
    
    public void hapus() throws SQLException {
        String id = drp.getId().getText();
        RenterImpl rti = new RenterImpl();
        rti.delete(id);
    }
}
