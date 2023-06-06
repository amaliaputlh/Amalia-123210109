/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author msi-modern
 */
public class RoomsTabelModel extends AbstractTableModel {
    List<Rooms> rms;

    public RoomsTabelModel(List<Rooms> rms) {
        this.rms = rms;
    }
    
    @Override
    public int getRowCount() {
        return rms.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Name";
            case 1: return "Size";
            case 2: return "Price";
            case 3: return "Status";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col) {
             case 0:
                return rms.get(row).getName();
            case 1:
                return rms.get(row).getSize();
            case 2:
                return rms.get(row).getPrice();
            case 3:
                return rms.get(row).getStatus();
            default:
                return null;
        }
    }
}
