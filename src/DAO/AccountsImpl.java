/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.Connector;
import model.Accounts;

/**
 *
 * @author msi-modern
 */
public class AccountsImpl implements AccountsDAO {
    Connection con;

    public AccountsImpl() {
        con  = Connector.getConnection();
    }
    
    private static String select = "SELECT * FROM accounts WHERE";
    @Override
    public void insert(Accounts t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Accounts t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Accounts> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getAcc(String u, String p) throws SQLException {
        String role = "";
        try{
            Statement st = con.createStatement();
            String select = "SELECT * FROM accounts WHERE username = \"" + u + "\" AND password = \"" + p + "\"";
            System.out.println(select);
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                role = rs.getString("role");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(role);
        return role;
    }
}
