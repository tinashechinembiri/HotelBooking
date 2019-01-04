package com.tinashe.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.tinashe.persistance.Name;

public class ListTableModel extends AbstractTableModel {

	private List<Name> rows;
    private List<String> columnNames;
    
    
    public ListTableModel(List<String> columnNames, List<Name> rows) {
        this.rows = new ArrayList<>(rows);
        this.columnNames = columnNames;
        System.out.println(this.rows);
    }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.size();
	}
	 


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	 @Override
	 public Object getValueAt(int row, int column) {
	        Object value = null;
	        Name client = rows.get(row);

	        switch (column) {
	            case 0:
	                value = Long.toString(client.getId());
	                break;
	            case 1:
	                value = client.getFirst_name();
	                break;
	            case 2:
	                value = client.getLast_name();
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
