/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.AdminController;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.AdminTabelModel;

public class AdminPageView extends JFrame { 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    AdminController admc;
    String data[][] = new String [100][4];
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    JTable tabel = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    JButton blogout = new JButton("Logout");
    JButton bshow = new JButton("Show Data");

    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(blogout);
        window.add(bshow);
        scrollPane.setBounds(20, 35, 500, 300);
        blogout.setBounds(20, 350, 100,50);
        bshow.setBounds(140, 350, 100,50);
        
        admc = new AdminController(this);
        admc.isiTabel();
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                klikTabel(evt);
            }
        });
        
        blogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });
        
        bshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showData(evt);
            }
        });
        
    }
    
    private void showData(ActionEvent evt){
        admc = new AdminController(this);
        admc.isiTabel();
    }
    
    private void klikTabel(MouseEvent evt) {
        int baris = tabel.getSelectedRow();
        String status = tabel.getValueAt(baris,5).toString();
        if("notPaid".equals(status)) {
            ConfirmAdminPage cf = new ConfirmAdminPage();
            cf.getId().setText(tabel.getValueAt(baris, 1).toString());
            cf.getNama().setText(tabel.getValueAt(baris, 0).toString());
            cf.setVisible(true);
            cf.setLocationRelativeTo(null);
        } else if ("Paid".equals(status)){
            DeleteRentPage drp = new DeleteRentPage();
            drp.getId().setText(tabel.getValueAt(baris, 1).toString());
            drp.getNama().setText(tabel.getValueAt(baris, 0).toString());
            drp.setVisible(true);
            drp.setLocationRelativeTo(null);
        }
    }
    
    private void logout(ActionEvent evt) {
        this.dispose();
    }
    
    public JTable getTabel() {
        return tabel;
    }

    public void setTabel(JTable tabel) {
        this.tabel = tabel;
    }
    
    
}
