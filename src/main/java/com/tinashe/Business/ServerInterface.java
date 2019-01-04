package com.tinashe.Business;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tinashe.persistance.Name;
import com.tinashe.persistance.Room;
//ternary operator
public interface  ServerInterface {
	BookingDetails returnitems = new BookingDetails(); 
	DatabaseBusiness sqldata = new DatabaseBusiness(); 
	default public List<Name> returnindividual (Long id )
	{
		return returnitems.returnindividual(id); 
	}
	default public List<Name> getdata ()
	{
		return returnitems.getdata(); 
	}
	default public Boolean Login (String username, String password )
	{
		return sqldata.Login(username, password);
	}
	default public ArrayList<Room> getroom (String room)
	{
		return sqldata.getroom(room); 
	}
	default public ArrayList<String> getroomtypes()
	{
		return sqldata.getroomtypes(); 
	}
	default public Name addName (Name name )
	{
		return sqldata.addName(name); 
	}
	
}
