package com.tinashe.Hotel_Booking;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.tinashe.Business.BusinessLogic;
import com.tinashe.Event.MainEvent;

public class App 
{
	// accounttype 
	// username
	// password 
	// submit
	private JFrame mainframe ; 
	private JPanel Panel;
	 private JLabel headerLabel;
	 
	public App ()
	 {
		startGui (); 
	 }
    public void startGui ()
    {
    	this.mainframe = new JFrame ("hotel booking"); 
    	this.mainframe.setSize(900,900); 
    	this.mainframe.setLayout(new GridLayout (2,2));
    	headerLabel = new JLabel("Login page",JLabel.CENTER );
    	this.Panel = new JPanel();
    	
    	this.mainframe.add(headerLabel); 
    	this.mainframe.add(Panel); 
    	this.mainframe.setVisible(true);
    
    	}
    public void addFunction()
    {
    	JLabel username = new JLabel("Username"); 
    	JTextField username_input = new JTextField (6); 
    	JLabel password = new JLabel("Password"); 
    	JPasswordField password_input = new JPasswordField(6); 
    	JButton check = new JButton ("Submit"); 
    	this.Panel.add(username);
    	this.Panel.add(username_input);
    	this.Panel.add(password);
    	this.Panel.add(password_input);
    	this.Panel.add(check);
    	this.mainframe.setVisible(true);
    	check.setEnabled(false);
    	BusinessLogic securitycheck = new BusinessLogic (check, username_input, password_input); 
    	password_input.getDocument().addDocumentListener(securitycheck); 
    	MainEvent submit = new MainEvent(username_input, password_input); 
    	check.addActionListener(submit);
    	System.out.println(String.valueOf(username_input.getText()));
    	
    }
}
