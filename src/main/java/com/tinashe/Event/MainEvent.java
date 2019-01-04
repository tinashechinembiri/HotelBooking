package com.tinashe.Event;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tinashe.Business.DatabaseBusiness;
import com.tinashe.Business.ServerInterface;
import com.tinashe.Hotel_Booking.Bookpage;

public class MainEvent implements ActionListener{
	private JTextField usernamevalue; 
	private JPasswordField  passwordvalue;
	private ServerInterface setData = new DatabaseBusiness(); 
	
	public MainEvent (JTextField username , JPasswordField password)
	{
		
		this.passwordvalue = password; 
		this.usernamevalue = username;

	}
	
	 public void actionPerformed (ActionEvent e)
	 {
		String ps =  String.valueOf(this.passwordvalue.getPassword()); 
		String user = this.usernamevalue.getText(); 
		
	   if ( this.setData.Login(user,ps) == true)
	   {
		   Bookpage start = new Bookpage(); 
		   start.createLayout();
	   }
	   else 
	   {
		   JOptionPane.showMessageDialog(null,"failed login in");
	   }
			 
		 
	 }
	

}
