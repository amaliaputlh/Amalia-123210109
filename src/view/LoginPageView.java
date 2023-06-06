    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author OWNER
 */
public class LoginPageView extends JFrame{
 
    JLabel ltitle = new JLabel("Login");
    
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    JButton blogin = new JButton("Login");
    
    public LoginPageView(){
        LoginPageView lp = this;
        setSize(800, 600);
        setTitle("Login Page");
        setVisible(true);
        setLayout(null);
        
        setLocationRelativeTo(null);
        
        add(ltitle);
        add(lusername);
        add(lpassword);
        add(fusername);
        add(fpassword);
        add(blogin);
        
        ltitle.setBounds(365, 50, 75, 50);
        
        lusername.setBounds(275, 120, 100, 30);
        fusername.setBounds(275, 150, 250, 30);
        
        lpassword.setBounds(275, 180, 100, 30);
        fpassword.setBounds(275, 210, 250, 30);
        
        blogin.setBounds(350, 260, 100, 30);
        
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login(evt);
            }
        });
    }
    
    private void login(ActionEvent evt) {
        try {
            LoginController lc = new LoginController(this);
            boolean login = lc.login();
            if (login) {
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPageView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JTextField getFusername() {
        return fusername;
    }

    public void setFusername(JTextField fusername) {
        this.fusername = fusername;
    }

    public JPasswordField getFpassword() {
        return fpassword;
    }

    public void setFpassword(JPasswordField fpassword) {
        this.fpassword = fpassword;
    }

    public JButton getBlogin() {
        return blogin;
    }

    public void setBlogin(JButton blogin) {
        this.blogin = blogin;
    }
    
    
}

