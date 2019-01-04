package com.tinashe.Hotel_Booking;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.tinashe.Business.BookingDetails;
import com.tinashe.Business.ServerInterface;
import com.tinashe.Event.BookingMouse;
import com.tinashe.persistance.Room;
import com.tinashe.util.ListTableModel;

public class BookedRoomdetails {
	private JFrame mainframe ; 
	private JPanel Panel;
	private JPanel datepickers;
	private JPanel headerpanel; 
	 private JLabel headerLabel;
	 private JPanel Paneltwo;
	 ServerInterface item = new BookingDetails(); 
	 
	
	public BookedRoomdetails ()
	{
		startGui ();
		
	}
	  public void startGui ()
	    {
	    	this.mainframe = new JFrame ("Bookeddetails"); 
	    	this.mainframe.setSize(900,900); 
	    	this.mainframe.setLayout(new GridLayout(5,2));
	    	headerLabel = new JLabel("booked details",JLabel.CENTER );
	    	this.Panel = new JPanel();
	    	this.headerpanel = new JPanel(); 
	    	this.Paneltwo = new JPanel();
	    	this.Paneltwo.setLayout(new FlowLayout() );
	    	this.mainframe.add(headerpanel); 
	    	this.mainframe.add(headerLabel);  	
	    	this.mainframe.add(Panel); 
	    	this.mainframe.add(Paneltwo); 
	    	this.mainframe.setVisible(true);
	    	}
	public void setailslayout ()
	{
		//DefaultListModel<String> model = new DefaultListModel<>();
			//JList<String> userinfo = new JList<String> (model); 
		List<String> columns = Arrays.asList("id", "Name", "Surname");
				
		   JTable table = new JTable(new ListTableModel(columns,item.getdata())); 
		   table.setPreferredScrollableViewportSize(new Dimension(480, 70)); 
			this.Panel.add(new JScrollPane(table));
			this.mainframe.setVisible(true);
			BookingMouse clickdata = new BookingMouse(table); 
			table.addMouseListener(clickdata);
			
			//item.getdata().stream().forEach(user ->{ userinfo(user); System.out.println(user);});
	}

}
