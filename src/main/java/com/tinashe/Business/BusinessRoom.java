package com.tinashe.Business;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tinashe.persistance.Name;
import com.tinashe.persistance.Room;

public class BusinessRoom extends DatabaseBusiness {
	
	public BusinessRoom()
	{
		super(); 
	}
	
	public Date findRoomnumber (String room)
	{
		String sql = "SELECT * FROM name WHERE room_number='"+room+"'";
		
		try {
			ResultSet result = super.stmt.executeQuery(sql);
			while (result.next())
			{
				Name data = super.setNamedata(result); 
				return data.getCheckout(); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			   
		    if (super.stmt != null) {
		        try {
		            super.stmt.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (super.conn != null) {
		        try {
		            super.conn.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		
		return java.sql.Date.valueOf(LocalDate.now()); 
	}
	public List<Name> returnindividual ()
	{
		
		String sql = "SELECT * FROM name";
		ArrayList<Name> getinfo  = new ArrayList<Name>(); 
		try {
			ResultSet result = super.stmt.executeQuery(sql);
			while (result.next())
			{
				Name perinfo = super.setNamedata(result);
				getinfo.add(perinfo);			
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return getinfo; 
	}
	public ArrayList<Room> getroom ()
	{
		
		String sql = "SELECT * FROM rooms";
		ArrayList <Room> returndata = new ArrayList <Room>(); 
		try {
			ResultSet result = this.stmt.executeQuery(sql); 
			
			while (result.next())
			{
				Room data = super.setalldata(result); 
				
				returndata.add(data); 	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return returndata; 
	}

}
