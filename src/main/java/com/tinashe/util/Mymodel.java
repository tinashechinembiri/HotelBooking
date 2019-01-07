package com.tinashe.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.tinashe.persistance.Name;

public class Mymodel extends AbstractTableModel {
	private List<Name> rows;
    private List<String> columnNames;
    
    
    public Mymodel(List<String> columnNames, List<Name> rows) {
        this.rows = new ArrayList<>(rows);
        this.columnNames = columnNames;
   
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
	            case 3: 
	            	value = client.getPhonenumber(); 
	            	break;
	            case 4: 
	            	value = client.getEmail(); 
	            	break; 
	            case 5: 
	            	value = client.getCheckin(); 
	            case 6 : 
	            	value = client.getCheckout(); 
	            	break; 
	            case 7 : 
	            	value = client.getAmountpaid(); 
	            	break;
	            case 8 : 
	            	value = client.getRoom_type(); 
	            	break; 
	            case 9 : 
	            	value = client.getRoom_number(); 
	         
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
