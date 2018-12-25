package com.tinashe.persistance;

public class Room {
	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", room_number=" + room_number + ", room_type=" + room_type + "]";
	}
	private long room_id; 
	private int room_number;
	private String room_type;
	public long getRoom_id() {
		return room_id;
	}
	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public Room(long room_id, int room_number, String room_type) {
		super();
		this.room_id = room_id;
		this.room_number = room_number;
		this.room_type = room_type;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	} 

}
