/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.RoomListController;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RoomListView extends JFrame{ 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    RoomListController rlc = new RoomListController(this);
    
    String data[][] = new String [100][4];
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    JTable tabel = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(tabel);
    
    JButton bcancel = new JButton("Logout");

    public RoomListView(){
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(bcancel);
        scrollPane.setBounds(20, 35, 500, 300);
        bcancel.setBounds(20, 350, 100,50);
        rlc.isiTabel();
        
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                klikTabel(evt);
            }
        });
        
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout(evt);
            }
        });
        
    }
    
    private void klikTabel(MouseEvent evt){
        int baris = tabel.getSelectedRow();
        String status = tabel.getValueAt(baris,3).toString();
        if("empty".equals(status)) {
            RenterDataView rdv = new RenterDataView();
            rdv.getLprice().setText(tabel.getValueAt(baris, 2).toString());
            rdv.getLroom().setText(tabel.getValueAt(baris, 0).toString());
            rdv.setVisible(true);
            rdv.setLocationRelativeTo(null);
            this.dispose();
        }
    }
    
    private void logout(ActionEvent evt) {
        JFrame logim = new LoginPageView();
        logim.setVisible(true);
        this.dispose();
       
    }

    public JTable getTabel() {
        return tabel;
    }

    public void setTabel(JTable tabel) {
        this.tabel = tabel;
    }
    
    
}
