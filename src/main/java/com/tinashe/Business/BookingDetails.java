package com.tinashe.Business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tinashe.persistance.Name;

public class BookingDetails extends DatabaseBusiness implements ServerInterface {
	
	public BookingDetails()
	{
		super(); 
	}
	public List<Name> returnindividual (Long id )
	{
		
		String sql = "SELECT * FROM name WHERE id='"+id+ "'";
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
		
		return getinfo; 
	}
	
	public List<Name> getdata ()
	{
		
		String sql = "SELECT * FROM name";
		ArrayList<Name> getinfo  = new ArrayList<Name>(); 
		List<List<String>> listOfLists = new ArrayList<List<String>>(); 
		try {
			ResultSet result = super.stmt.executeQuery(sql);
			while (result.next())
			{
				Name perinfo = setdata ( result); 
				getinfo.add(perinfo);	
				
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
		
		return getinfo; 
	}
	private Name setdata (ResultSet result)
	{
		Name perinfo = new Name ();  
		try {
			perinfo.setId(result.getLong("id"));
			perinfo.setFirst_name(result.getString("First_name"));
			perinfo.setLast_name(result.getString("Last_name"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return perinfo; 
		
	}
	
	

}
