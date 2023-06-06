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
public class AdminTabelModel extends AbstractTableModel {
    List<Renter> rts;

    public AdminTabelModel(List<Renter> rts) {
        this.rts = rts;
    }
    
    @Override
    public int getRowCount() {
        return rts.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "name";
            case 1: return "id";
            case 2: return "contact";
            case 3: return "duration";
            case 4: return "bill";
            case 5: return "status";
            case 6: return "room";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col) {
             case 0:
                return rts.get(row).getName();
            case 1:
                return rts.get(row).getId();
            case 2:
                return rts.get(row).getContact();
            case 3:
                return rts.get(row).getDuration();
            case 4:
                return rts.get(row).getBill();
            case 5:
                return rts.get(row).getStatus();
            case 6:
                return rts.get(row).getRoom();
            default:
                return null;
        }
    }
    
}
