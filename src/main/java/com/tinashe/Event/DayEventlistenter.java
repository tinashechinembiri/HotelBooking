package com.tinashe.Event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.tinashe.Business.BusinessRoom;

public class DayEventlistenter  implements ItemListener{
	private JComboBox<Integer> roominfo; 
	 BusinessRoom data = new BusinessRoom(); 
	public DayEventlistenter (JComboBox<Integer> roominfo)
	{
		this.roominfo = roominfo; 	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
		int namechange  = (int)	this.roominfo.getSelectedItem();
		String getnumber = String.valueOf(namechange); 
		
		if (this.data.findRoomnumber(getnumber).after(java.sql.Date.valueOf(LocalDate.now())))
		{
			JOptionPane.showMessageDialog(null,
                    "cant book alredy been booked");	
		}
	
		}		
	}

}
