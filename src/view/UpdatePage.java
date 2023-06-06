/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DAO.RenterImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.Renter;

/**
 *
 * @author Orenji
 */
public class UpdatePage extends JFrame {
    JFrame window = new JFrame("Update Data");
   
    JLabel lName = new JLabel("Name ");
    JTextField tfName = new JTextField();
    JLabel lid = new JLabel("id ");
    JLabel tfid = new JLabel();
    JLabel lContact= new JLabel("Contact ");
    JTextField tfContact = new JTextField();
    JLabel lRentTime = new JLabel("RentTime ");
    JTextField tfRentTime = new JTextField();

    JButton btnSubmit = new JButton("Update");
    JButton btnLogout = new JButton("Batal");

    public UpdatePage() {
        window.setLayout(null);
        window.setSize(550,200);
        // window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lName);
        window.add(tfName);
        window.add(lid);
        window.add(tfid);
        window.add(lContact);
        window.add(tfContact);
        window.add(lRentTime);
        window.add(tfRentTime);
        window.add(btnSubmit);
        window.add(btnLogout);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lid.setBounds(5, 55, 120, 20);
        lContact.setBounds(5,80,120,20);
        lRentTime.setBounds(5,110,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfid.setBounds(110, 60, 120, 20);
        tfContact.setBounds(110, 85, 120, 20);
        tfRentTime.setBounds(110, 115, 120, 20);


//BUTTON PANEL
        btnSubmit.setBounds(250, 35, 90, 20);
        btnLogout.setBounds(250, 65, 90, 20);
        
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    updateData(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdatePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });
    }
    
    private void logout(ActionEvent evt) {
        dispose();
    }
    
    private void updateData(ActionEvent evt) throws SQLException {
        RenterImpl rti = new RenterImpl();
        Renter renter = new Renter();
        renter.setName(tfName.getText());
        renter.setDuration(Integer.parseInt(tfRentTime.getText()));
        renter.setContact(tfContact.getText());
        renter.setId(Integer.parseInt(tfid.getText()));
        rti.update(renter);
        dispose();
    }

    public JLabel getTfid() {
        return tfid;
    }

    public void setTfid(JLabel tfid) {
        this.tfid = tfid;
    }
    
    
}

