package com.tinashe.Event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import com.tinashe.Business.DatabaseBusiness;
import com.tinashe.Business.ServerInterface;
import com.tinashe.Hotel_Booking.BookedRoomdetails;
import com.tinashe.Hotel_Booking.BookingInformation;
import com.tinashe.persistance.Name;
import com.tinashe.persistance.Room;

public class BookingEvent implements ActionListener {
	private JTextField name; 
	private JTextField last;
	private JTextField email;
	private JTextField phonenumber; 
	private JDatePickerImpl checkin ;
	private JDatePickerImpl checkout ;
	JTextField price; 
	JComboBox<String> data; 
	JComboBox<Integer> roominfo;
	private ServerInterface setData = new DatabaseBusiness(); 

	
	public BookingEvent ()
	{
	
	}

	public BookingEvent(JTextField name, JTextField last, JTextField email, JTextField phonenumber,
			JDatePickerImpl checkin, JDatePickerImpl checkout,  JTextField price,JComboBox<String> data, JComboBox<Integer> roominfo) {
		super();
		this.name = name;
		this.last = last;
		this.email = email;
		this.phonenumber = phonenumber;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price; 
		this.data = data; 
		this.roominfo = roominfo; 
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn  = (JButton) e.getSource();
		if (btn.getLabel().equals("Booking"))
		{
		String Textname = this.name.getText();String Textlast = this.last.getText();String TextEmail = this.email.getText(); 
		int Textphonenumber =  Integer.parseInt(this.phonenumber.getText()); 
		Date checkindate = (Date) checkin.getModel().getValue();
	    Date checkoutdate = (Date) checkout.getModel().getValue();
	    
	    java.sql.Date checkin = new java.sql.Date(checkindate.getTime());
	    java.sql.Date checkout = new java.sql.Date(checkoutdate.getTime());
	    
	    int  prices =  Integer.parseInt(this.price.getText()); 
	    String roomtype = this.data.getSelectedItem().toString();
	    
	    String roominfo = this.roominfo.getSelectedItem().toString();
	    Name senddata = inputBooking(Textname ,  Textlast, TextEmail,  Textphonenumber, checkin, checkout, prices, roomtype, roominfo ); 
	    
		this.setData.addName(senddata); 
		}
		else if (btn.getLabel().equals("GuestLedge"))
		{
			BookedRoomdetails mn = new BookedRoomdetails(); 
			mn.setailslayout (); 
		}
		else if (btn.getLabel().equals("guestdetails"))
		{
			BookingInformation mn = new BookingInformation (); 
			mn.bookedinformation();
		}
	    
		}
	
	private Name inputBooking (String Textname , String Textlast, String TextEmail, int Textphonenumber, Date checkin,Date checkout, int prices, String roomtypes, String roominfo )
	{
		Name setdata = new Name(); 
		setdata.setFirst_name(Textname);
		setdata.setLast_name(Textlast);
		setdata.setEmail(TextEmail);
		setdata.setPhonenumber(Textphonenumber);
		setdata.setCheckin((java.sql.Date) checkin );
		setdata.setCheckout((java.sql.Date) checkout);
		setdata.setAmountpaid(prices);
		setdata.setRoom_type(roomtypes);
		setdata.setRoom_number(roominfo);
		
		return setdata; 
	}
	
	

}
