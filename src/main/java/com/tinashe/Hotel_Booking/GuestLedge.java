package com.tinashe.Hotel_Booking;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tinashe.Business.BookingDetails;
import com.tinashe.Business.ServerInterface;
import com.tinashe.util.Mymodel;

//-should be able to display the rooms that are booked and not 
//- avalable rooms and booked rooms 
//- using date to check for check out and not
//- seachrooms 

public class GuestLedge {
	
	private JFrame mainframe ; 
	private JPanel Panel;
	 private JLabel headerLabel;
	 private Long id ; 
	 ServerInterface  item = new BookingDetails(); 
	 public GuestLedge (String id )
	 {
		 this.id = Long.parseLong(id); 
		 
		 startGui(); 
		 
	 }
	  public void startGui ()
	    {
	    	this.mainframe = new JFrame ("Individual ledger"); 
	    	this.mainframe.setSize(900,900); 
	    	this.mainframe.setLayout(new GridLayout (2,2));
	    	headerLabel = new JLabel("Individual ledger",JLabel.CENTER );
	    	this.Panel = new JPanel();
	    	
	    	this.mainframe.add(headerLabel); 
	    	this.mainframe.add(Panel); 
	    	this.mainframe.setVisible(true);
	    
	    }
		public void setailslayout ()
		{
			List<String> columns = Arrays.asList("id", "Firstname", "Last_name", "phonenumber", "email", "checkin", "checkout", "amountpaid", "room_type", "room_number");
			JTable table = new JTable(new Mymodel(columns,item.returnindividual(this.id))); 
			table.setPreferredScrollableViewportSize(new Dimension(1500, 100)); 
			this.Panel.add(new JScrollPane(table));
			this.mainframe.setVisible(true);
			System.out.println(LocalDate.now());	
		}
	  

}
