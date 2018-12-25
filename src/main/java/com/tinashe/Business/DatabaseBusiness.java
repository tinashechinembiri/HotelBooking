package com.tinashe.Business;
import java.sql.*;
import java.util.ArrayList;

import com.tinashe.persistance.Account;
import com.tinashe.persistance.Name;
import com.tinashe.persistance.Room;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.sql.rowset.BaseRowSet; 

public class DatabaseBusiness {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/users"; 
	static final String DB_USER = "root"; 
	static final String DB_PASS=  "gangster01";
	
	Connection conn = null;
    Statement stmt = null;
	
	public DatabaseBusiness() 
	{
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(DB_URL,DB_USER , DB_PASS);
			this.stmt = conn.createStatement();
			
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Statement getStmt() {
		return stmt;
	}

	
	public Boolean Login (String username, String password )
	{
		Boolean Login = false ; 
		
		String sql = "select username,password from account where username='"+username+"'and password='"+password+"'";
		try {
			ResultSet result = this.stmt.executeQuery(sql);
			if (result.next())
			{
				Login = true;	 
				System.out.println(username+  password);
			}
			else
			{
				System.out.println(username+  password);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return Login; 
		
	}
	public ArrayList<Room> getroom (String room)
	{
		String sql = "SELECT * FROM rooms WHERE room_type='"+room+ "'";
		ArrayList <Room> returndata = new ArrayList <Room>(); 
		try {
			ResultSet result = this.stmt.executeQuery(sql); 
			
			while (result.next())
			{
				Room data = setalldata(result); 
				
				returndata.add(data); 	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return returndata; 
	}
	public ArrayList<String>  getroomtypes()
	{
		ArrayList <String> returndata = new ArrayList <String>();
		String sql = "SELECT * FROM room_details";
		try {
			ResultSet result = this.stmt.executeQuery(sql);
			
			while (result.next())
			{
				returndata.add( result.getString("room_type")); 
				
				 	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return returndata ; 
	}
	private Room setalldata (ResultSet result ) throws SQLException
	{
		 Room check = new Room(); 
		 check.setRoom_id(result.getInt("room_id"));
		 check.setRoom_number(result.getInt("room_number"));
		 check.setRoom_type(result.getString("room_type"));
		 return check;
	}
	
	public Name addName (Name name )
	{
		//String sql =  "INSERT INTO name VALUES (  " +  name.getFirst_name() + ", '" +name.getLast_name() + "','" +name.getPhonenumber() + "' '"+ name.getEmail() +"' )";
		String sql =  "INSERT INTO name VALUES ( NULL, ?, ?, ?, ?, ?, ?, ?,?,?)";
		try 
		{
			 PreparedStatement ps  = this.stmt.getConnection().prepareStatement(sql); 
			 ps.setString(1, name.getFirst_name());
			 ps.setString(2, name.getLast_name());
			 ps.setInt(3, name.getPhonenumber());
			 ps.setString(4, name.getEmail());
			 ps.setDate(5, name.getCheckin());
			 ps.setDate(6,  name.getCheckout());
			 ps.setInt(7, name.getAmountpaid());
			 ps.setString(8, name.getRoom_type());
			 ps.setString(9, name.getRoom_number());
			 ps.executeUpdate(); 
			 
			 return name; 
			 
			 
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
