package com.hrs.bo;

import java.sql.Date;

public class RoomDetailsBo {
	protected int roomId;
	protected String roomType;
	protected int capacity;
	protected Date date;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RoomDetailsBo() {
		super();
	}
	
	public RoomDetailsBo(int roomId, String roomType, int capacity, Date date) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.capacity = capacity;
		this.date = date;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "RoomDetailsBo [roomId=" + roomId + ", roomType=" + roomType + ", capacity=" + capacity + "]";
	}
	

}
