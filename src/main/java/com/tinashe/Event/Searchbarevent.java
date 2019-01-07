package com.tinashe.Event;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Searchbarevent implements DocumentListener{

	private JTextField searchbar; 
	private JTable table; 
	public Searchbarevent (JTable table, JTextField searchbar)
	{
		this.table = table; 
		this.searchbar = searchbar; 
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		String text = this.searchbar.getText(); 
		TableRowSorter<TableModel> rowSorter
        = new TableRowSorter<>(this.table.getModel());
		table.setRowSorter(rowSorter);
		
		if (text.trim().length() == 0)
		{
			rowSorter.setRowFilter(null);
		}
		else
		{
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		String text = this.searchbar.getText(); 
		TableRowSorter<TableModel> rowSorter
        = new TableRowSorter<>(this.table.getModel());
		table.setRowSorter(rowSorter);
		
		if (text.trim().length() == 0)
		{
			rowSorter.setRowFilter(null);
			
		}
		else
		{
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
			
		}
	}
	
	

}
