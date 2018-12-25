package com.tinashe.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Account {
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password ;
	//private String Email;
	//private int phonenumber; 
	
	public String getUsername() {
		return username;
	}
	public Account(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
