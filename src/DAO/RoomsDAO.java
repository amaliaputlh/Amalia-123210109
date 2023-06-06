/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Rooms;

/**
 *
 * @author msi-modern
 */
public interface RoomsDAO extends DAO {
    public void insert(Rooms t) throws SQLException;
    public void update(Rooms t) throws SQLException;
    public void delete(int i) throws SQLException;
    List<Rooms> getAll() throws SQLException;
}
