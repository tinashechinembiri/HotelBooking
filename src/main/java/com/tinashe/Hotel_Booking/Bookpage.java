package com.tinashe.Hotel_Booking;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import java.util.Properties;
import org.jdatepicker.impl.*;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tinashe.Business.DatabaseBusiness;
import com.tinashe.Business.DateLabelFormatter;
import com.tinashe.Business.ServerInterface;
import com.tinashe.Event.BookingEvent;
import com.tinashe.Event.Comboboxevent;


public class Bookpage {
	 private JFrame mainframe ; 
	 private JPanel Panel;
	 private JPanel datepickers;
	 private JPanel headerpanel; 
	 private JLabel headerLabel;
	 private JPanel Paneltwo;
	 private JButton roomsBooked; 
	 private JButton guestdetails; 
	 ServerInterface setData = new DatabaseBusiness(); 
	
	 public Bookpage ()
	 {
		startGui (); 
	 }
	  public void startGui ()
	    {
	    	this.mainframe = new JFrame ("hotel booking"); 
	    	this.mainframe.setSize(900,900); 
	    	this.mainframe.setLayout(new GridLayout(5,2));
	    	headerLabel = new JLabel("Booking page",JLabel.CENTER );
	    	this.Panel = new JPanel();
	    	this.headerpanel = new JPanel(); 
	    	this.Paneltwo = new JPanel();
	    	this.Paneltwo.setLayout(new FlowLayout() );
	    	this.datepickers = new JPanel();
	    	this.mainframe.add(headerpanel); 
	    	this.mainframe.add(headerLabel); 
	    	this.mainframe.add( datepickers);
	    	this.mainframe.add(Panel); 
	    	this.mainframe.add(Paneltwo); 
	    	this.mainframe.setVisible(true);
	    
	   }
	  public void createLayout ()
	  {
		  Properties p = new Properties();
		  p.put("text.today", "Today");
		  p.put("text.month", "Month");
		  p.put("text.year", "Year");
		  
		  UtilDateModel model = new UtilDateModel();
		  UtilDateModel model1 = new UtilDateModel();
		  JDatePanelImpl datePanel = new JDatePanelImpl(model, p); 
		  JDatePanelImpl checkoutdate = new JDatePanelImpl(model1, p);
		  JDatePickerImpl checkoutpicker = new JDatePickerImpl(checkoutdate , new DateLabelFormatter() );
		  JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter() );
		  
		  JLabel Name = new JLabel("FirstName");
		  JTextField Firstname = new JTextField (6);
		  JLabel surname = new JLabel("Surname");
		  JTextField Secondname = new JTextField (6);
		  JLabel emaillabel = new JLabel("Email");
		  JTextField Email = new JTextField (6);
		  JLabel phone = new JLabel("phonenumber");
		  JTextField phonenumber = new JTextField (6);
		  JButton booking = new JButton ("Booking"); 
		  this.roomsBooked = new JButton ("GuestLedge"); 
		  this.guestdetails = new JButton ("guestdetails"); 
		  JTextField price = new JTextField (6);
		 
		  JComboBox<Integer> roominfo = new JComboBox<Integer> (); 
		  
		 JComboBox<String> data = new JComboBox<String> ();
		 setData.getroomtypes().stream().forEach(user -> {data.addItem(user);});
		  this.headerpanel.add(roomsBooked); 
		  this.headerpanel.add(guestdetails);
		  
		  this.Panel.add(Name);
		  this.Panel.add(Firstname);
		  this.Panel.add(surname);
		  this.Panel.add(Secondname);
		  
		  this.Paneltwo.add(emaillabel);
		  this.Paneltwo.add(Email);
		  this.Paneltwo.add(phone);
		  this.Paneltwo.add(phonenumber); 
		  this.Paneltwo.add(booking);
		  this.datepickers.add(new JLabel("check in"));
		  this.datepickers.add(datePicker);
		  this.datepickers.add(new JLabel("check out"));
		  this.datepickers.add(checkoutpicker); 
		  this.datepickers.add(new JLabel("Full price"));
		  this.datepickers.add(price);
		
		  
		  this.Paneltwo.add(data);
		  this.Paneltwo.add(roominfo);
		  this.mainframe.setVisible(true);
		  BookingEvent book = new BookingEvent (Firstname, Secondname,Email, phonenumber, datePicker, checkoutpicker,price, data, roominfo); 
		  booking.addActionListener(book);
		  this.roomsBooked.addActionListener(new BookingEvent());
		  this.guestdetails.addActionListener(new BookingEvent());
		  Comboboxevent mn = new Comboboxevent(data, datePicker, checkoutpicker, price,roominfo); 
		  data.addItemListener(mn);
		  
	}
	

}
