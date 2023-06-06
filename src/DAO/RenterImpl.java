/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Connector;
import model.Renter;

/**
 *
 * @author msi-modern
 */
public class RenterImpl implements RenterDAO {
    Connection con;
    private static String select = "SELECT * FROM renter";

    public RenterImpl() {
        con = Connector.getConnection();
    }
    
    
    @Override
    public void insert(Renter t) throws SQLException {
        String insert = "INSERT INTO renter (name, id, contact, duration, bill, status, room) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(insert);
            st.setString(1, t.getName());
            st.setString(3, t.getContact());
            st.setString(6, t.getStatus());
            st.setString(7, t.getRoom());
            st.setInt(2, t.getId());
            st.setInt(4, t.getDuration());
            st.setInt(5, t.getBill());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Renter t) throws SQLException {
        String update = "UPDATE renter SET name = \"" + t.getName() + "\", duration = \"" + t.getDuration() + "\", contact = \"" + t.getContact()  + "\" WHERE id = \"" + t.getId() + "\"";
        Statement st = con.createStatement();
        st.executeUpdate(update);
    }
    
    public void update(String id) throws SQLException {
        String update = "UPDATE renter SET status = 'Paid' WHERE id = " + id;
        Statement st = con.createStatement();
        st.executeUpdate(update);
    }

    @Override
    public void delete(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void delete(String id) throws SQLException {
        String delete = "DELETE FROM renter WHERE id = \"" + id + "\"";
        Statement st = con.createStatement();
        st.executeUpdate(delete);
    }

    @Override
    public List<Renter> getAll() throws SQLException {
        List<Renter> rts = null;
        try {
             rts = new ArrayList<Renter>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Renter rt = new Renter();
                rt.setName(rs.getString("name"));
                rt.setId(rs.getInt("id"));
                rt.setContact(rs.getString("contact"));
                rt.setDuration(rs.getInt("duration"));
                rt.setBill(rs.getInt("bill"));
                rt.setStatus(rs.getString("status"));
                rt.setRoom(rs.getString("room"));
                rts.add(rt);
            }
        } catch(SQLException ex) {
            Logger.getLogger(AccountsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rts;
    }
    
    public String getAcc(String u, String p) throws SQLException {
        String role = "";
        try{
            Statement st = con.createStatement();
            String select = "SELECT * FROM renter WHERE username = \"" + u + "\" AND password = \"" + p + "\"";
            System.out.println(select);
            ResultSet rs = st.executeQuery(select);
            System.out.println();
            while(rs.next()){
                role = rs.getString("role");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return role;
    }
}
