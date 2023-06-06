/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.List;
import model.Accounts;

/**
 *
 * @author msi-modern
 */
public interface AccountsDAO extends DAO<Accounts>{
    public void insert(Accounts t) throws SQLException;
    public void update(Accounts t) throws SQLException;
    public void delete(int i) throws SQLException;
    List<Accounts> getAll() throws SQLException;
}
