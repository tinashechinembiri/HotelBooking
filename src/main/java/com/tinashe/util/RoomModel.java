package com.tinashe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import com.tinashe.persistance.Room;

public class RoomModel extends AbstractTableModel {

	private List<Room> rows;
    private List<String> columnNames = Arrays.asList("getRoom_number","getRoom_type" );
    
    
    public RoomModel(List<Room> rows) {
        this.rows = new ArrayList<>(rows); 
        System.out.println(this.rows);
    }
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}
	 
	@Override
	public int getRowCount() {	
		return rows.size();
	}

	 @Override
	 public Object getValueAt(int row, int column) {
	        Object value = null;
	        Room client = rows.get(row);

	        switch (column) {
	            case 0:
	                value = client.getRoom_number(); 
	                break;
	            case 1:
	                value = client.getRoom_type(); 
	                break;
	        }
	        return value;
	        
	    }
	@Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
	 @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        Class type = String.class;
	        return type;
	    }

}
