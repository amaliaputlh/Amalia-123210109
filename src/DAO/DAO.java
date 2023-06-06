/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author msi-modern
 */
public interface DAO<T> {
    public void insert(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(int i) throws SQLException;
    List<T> getAll() throws SQLException;
}
