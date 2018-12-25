package com.tinashe.persistance;

import java.sql.Date;

public class Name {
	
	private Long id ; 
	private String First_name; 
	private String Last_name ; 
	private int phonenumber;
	private String email; 
	private Date checkin; 
	private Date checkout; 
	private int amountpaid; 
	private String room_type; 
	private String room_number; 
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getAmountpaid() {
		return amountpaid;
	}

	public void setAmountpaid(int amountpaid) {
		this.amountpaid = amountpaid;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public Name(Long id, String first_name, String last_name, int phonenumber, String email, Date checkin,
			Date checkout, int amountpaid, String room_type, String room_number) {
		super();
		this.id = id;
		First_name = first_name;
		Last_name = last_name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.checkin = checkin;
		this.checkout = checkout;
		this.amountpaid = amountpaid;
		this.room_type = room_type;
		this.room_number = room_number;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return First_name;
	}
	public void setFirst_name(String first_name) {
		First_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	
	
	

}
