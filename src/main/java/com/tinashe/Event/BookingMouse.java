package com.tinashe.Event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import com.tinashe.Hotel_Booking.GuestLedge;

public class BookingMouse implements MouseListener  {
	
	private JTable table ; 
	public BookingMouse (JTable table )
	{
		this.table = table; 
		
	}

	@Override
	public void mouseClicked(MouseEvent mouseevent) {
	this.table = (JTable) mouseevent.getSource(); 
	if (mouseevent.getClickCount() == 2)
	{
		GuestLedge showind = new GuestLedge (getdetails());
		showind.setailslayout();
		
	}
		
	}
	private String getdetails()
	{
		 final int row = this.table.getSelectedRow();
         final int column = this.table.getSelectedColumn();
         final String valueInCell = (String)this.table.getValueAt(row, 0);   
         return valueInCell; 
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
