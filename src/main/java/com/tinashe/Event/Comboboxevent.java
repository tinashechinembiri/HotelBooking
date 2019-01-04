package com.tinashe.Event;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import com.tinashe.util.Convertorfunctions;
import com.tinashe.Business.DatabaseBusiness;
import com.tinashe.Business.ServerInterface;


public class Comboboxevent implements ItemListener{
	private JComboBox<String> item ; 
	private JDatePickerImpl checkin ;
	private JDatePickerImpl checkout ;
	private JTextField price; 
	private JComboBox<Integer> roominfo;
	Convertorfunctions convertitems = new Convertorfunctions(); 
	ServerInterface setData = new DatabaseBusiness();
	

	public Comboboxevent  (JComboBox<String> items, JDatePickerImpl checkin, JDatePickerImpl checkout,JTextField price,JComboBox<Integer> roominfo)
	{
		this.item = items; 
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price; 
		this.roominfo = roominfo; 
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Date checkindate = (Date) checkin.getModel().getValue();
	    Date checkoutdate = (Date) checkout.getModel().getValue(); 
	    if (checkindate == null && checkoutdate == null)
	    {
	    	JOptionPane.showMessageDialog(null,
                    "date not selectected ");
	    }
	    else 
		   if(e.getStateChange() == ItemEvent.SELECTED) {
               String a= this.item.getSelectedItem().toString();
               long datetodays =  convertitems.turndatestoday(checkindate, checkoutdate); 
               	DayEventlistenter mn = new DayEventlistenter(roominfo); 
           		roominfo.addItemListener(mn);
               if (a.equals("King"))
               {
            	   
            	   price.setText(String.valueOf(Totalprice(datetodays,100)));
            	   itemsroom ( a );
            	  
               }
               if (a.equals("Queen"))
               {
            	   price.setText(String.valueOf(Totalprice(datetodays,80)));
            	   itemsroom ( a );
               }
               if (a.equals("Double"))
               {
            	   price.setText(String.valueOf(Totalprice(datetodays,60)));
            	   itemsroom ( a );
               }
               if (a.equals("Single"))
               {
            	   price.setText(String.valueOf(Totalprice(datetodays,50)));
            	   itemsroom ( a );
               }
               if (a.equals("Quad"))
               {
            	   price.setText(String.valueOf(Totalprice(datetodays,74)));
            	   itemsroom ( a );
               }
               if (a.equals("Triple"))
               {
            	   price.setText(String.valueOf(Totalprice(datetodays,67)));
            	   itemsroom ( a );
               }
               
               }

}
private int Totalprice(long days,  int actualprice)
{
	int finalprice = 0;
	System.out.println(days);
	if (days < 1)
	{
	return actualprice; 
	}
	else	
	finalprice = actualprice * (int)days; 
	return finalprice; 
}

private void itemsroom (String a )
{
	if (this.roominfo.getItemCount() != 0 )
	{
		this.roominfo.removeAllItems();
		 setData.getroom(a).stream().forEach(user -> {this.roominfo.addItem(user.getRoom_number());});	
	}
	else 
	{
		setData.getroom(a).stream().forEach(user -> {this.roominfo.addItem(user.getRoom_number());}); 
	}	
	
	
}

}
