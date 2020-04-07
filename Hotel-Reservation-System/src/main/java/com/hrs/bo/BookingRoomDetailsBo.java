package com.hrs.bo;

import java.sql.Date;

public class BookingRoomDetailsBo {
	protected int roomId;
	protected int noOfGuest;
	protected String roomType;
	protected Date checkInDate;
	protected Date checkOutDate;
	
	public BookingRoomDetailsBo() {
		super();
	}
	public BookingRoomDetailsBo(int roomId, int noOfGuest, String roomType, Date checkInDate, Date checkOutDate) {
		super();
		this.roomId = roomId;
		this.noOfGuest = noOfGuest;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public int getNoOfGuest() {
		return noOfGuest;
	}
	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	@Override
	public String toString() {
		return "BookingRoomDetailsBo [roomId=" + roomId + ", noOfGuest=" + noOfGuest + ", roomType=" + roomType
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}
	
	

}
