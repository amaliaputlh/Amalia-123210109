/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;
import model.Renter;
import java.sql.SQLException;

/**
 *
 * @author msi-modern
 */
public interface RenterDAO extends DAO<Renter> {
    public void insert(Renter t) throws SQLException;
    public void update(Renter t) throws SQLException;
    public void delete(int i) throws SQLException;
    List<Renter> getAll() throws SQLException;
}
