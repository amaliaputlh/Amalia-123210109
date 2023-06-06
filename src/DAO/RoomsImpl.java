/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Connector;
import model.Rooms;

/**
 *
 * @author msi-modern
 */
public class RoomsImpl implements RoomsDAO {
    Connection con;
    
    public RoomsImpl() {
        con = Connector.getConnection();
    }
    @Override
    public void insert(Rooms t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Rooms t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object T) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void updateStatus(String name, String room) throws SQLException {
        String update = "UPDATE rooms SET status = \"" + name + "\" WHERE name = \"" + room + "\"";
        Statement st = con.createStatement();
        st.executeUpdate(update);
    }

    @Override
    public void insert(Object t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Rooms> getAll() throws SQLException {
        List<Rooms> rs = null;
        String select = "SELECT * FROM rooms";
        try {
            rs = new ArrayList<Rooms>();
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(select);
            while(res.next()){
                Rooms r = new Rooms();
                r.setName(res.getString("name"));
                r.setSize(res.getString("size"));
                r.setPrice(res.getInt("price"));
                r.setStatus(res.getString("status"));
                rs.add(r);
            }
        } catch(SQLException ex) {
            Logger.getLogger(AccountsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
}
