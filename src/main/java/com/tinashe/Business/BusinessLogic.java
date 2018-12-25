package com.tinashe.Business;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BusinessLogic implements DocumentListener{
	private JButton btn; 
	private String usernamevalue; 
	private String  passwordvalue; 
	
	public BusinessLogic (JButton btn , JTextField username , JPasswordField password)
	{
		this.btn = btn; 
		this.passwordvalue = new String (password.getPassword());  
		this.usernamevalue = username.getText(); 
		System.out.println(passwordvalue);
	}

	public void changedUpdate(DocumentEvent arg0) {
		if (!usernamevalue.isEmpty() && !passwordvalue.isEmpty())
		{
			JOptionPane.showMessageDialog(null,
                    "please enter at    least Three digits");
		}
		else
		{
			this.btn.setEnabled(true);
		}
		}

	public void insertUpdate(DocumentEvent arg0) {
		
		if (!usernamevalue.isEmpty() && !passwordvalue.isEmpty())
		{
			JOptionPane.showMessageDialog(null,
                    "please enter at    least Three digits");
		}
		else
		{
			this.btn.setEnabled(true);
		}
	
	}

	public void removeUpdate(DocumentEvent arg0) {
		if (!usernamevalue.isEmpty() && !passwordvalue.isEmpty())
		{
			JOptionPane.showMessageDialog(null,
                    "please enter at    least Three digits");
		}
		else
		{
			this.btn.setEnabled(true);
		}

	
	}

}
