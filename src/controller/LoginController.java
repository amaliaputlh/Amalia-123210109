/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.AccountsImpl;
import java.sql.SQLException;
import view.*;
import javax.swing.*;

/**
 *
 * @author msi-modern
 */
public class LoginController {
    AccountsImpl ai = new AccountsImpl();
    LoginPageView lp;

    public LoginController(LoginPageView lp) {
        this.lp = lp;
    }    
    
    public boolean login() throws SQLException {
        String userAdmin = lp.getFusername().getText();
        String passAdmin = lp.getFpassword().getText();
        String role = ai.getAcc(userAdmin, passAdmin);
        if (role.equals("admin")) {
            AdminPageView admin = new AdminPageView();
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            return true;
        }
        else if (role.equals("renter")) {
            JFrame rlv = new RoomListView();
            rlv.setVisible(true);
            rlv.setLocationRelativeTo(null);
            return true;
        }
        return false;
    }
}
