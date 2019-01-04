package com.tinashe.Hotel_Booking;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.tinashe.Business.BusinessRoom;
import com.tinashe.persistance.Name;
import com.tinashe.persistance.Room;
import com.tinashe.util.Constant;
import com.tinashe.util.Mymodel;
import com.tinashe.util.RoomModel;

public class BookingInformation {
	
	private JFrame mainframe ; 
	private JPanel Panel;
	 private JPanel Panelavailable;
	 JTable table;
	 BusinessRoom data = new BusinessRoom();
	 public BookingInformation ()
	 {
		 startGui(); 
	 }
	 public void startGui ()
	    {
	    	this.mainframe = new JFrame ("Individual ledger"); 
	    	this.mainframe.setSize(1000,1000); 
	    	this.mainframe.setLayout(new GridLayout (2,2));
	    	
	    	this.Panel = new JPanel(new FlowLayout());
	    	Panelavailable = new JPanel(new FlowLayout());
	   
	    	this.mainframe.add(Panel); 
	    	this.mainframe.add(Panelavailable);
	    	this.mainframe.setVisible(true);
	    
	    }
	 public void bookedinformation()
	 {
		 List<Name>  setavaiable = new ArrayList<Name>(); 
		 try {
		 for (Name a : data.returnindividual())
		 {
			 if (a.getCheckout().after(java.sql.Date.valueOf(LocalDate.now())))
			 {
				 	 setavaiable.add(a); 
					 table = new JTable(new Mymodel(Constant.columns,setavaiable));
			 }
		 }
		 }
		 catch (NullPointerException e )
		 {
			 System.out.println(e); 
		 }
		 System.out.println(roomsavailable(setavaiable));
		 JTable roomtable = new JTable(new RoomModel(roomsavailable(setavaiable)));
		 roomtable.setPreferredScrollableViewportSize(new Dimension(1200,80)); 
		 
		 this.table.setPreferredScrollableViewportSize(new Dimension(1200,80)); 
		 
		 this.Panel.add(new JLabel("rooms that are occupied",JLabel.CENTER));
		 this.Panel.add(new JScrollPane(this.table)); 
		 this.Panelavailable.add(new JScrollPane(roomtable)); 
		 this.mainframe.setVisible(true);
	 }
	private List<Room> roomsavailable( List<Name>  setavaiable) 
	{
		 List<Room>  availablerooms = new ArrayList<Room>(); 
		for (Room r : data.getroom())
		{
			for(Name n : setavaiable)
			{
			if (r.getRoom_number() != Integer.parseInt(n.getRoom_number()))
			{
				availablerooms.add(r); 	
			}
			}
		}
		
		return availablerooms; 
	}
}
