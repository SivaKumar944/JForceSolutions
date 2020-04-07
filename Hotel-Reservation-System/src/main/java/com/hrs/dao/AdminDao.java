package com.hrs.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hrs.bo.AdminBo;
import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.bo.VisitorLoginBo;
import com.hrs.bo.VisitorRegBo;
import com.hrs.exception.AdminNotFoundException;
import com.hrs.exception.VisitorNotFoundExeption;

@Repository
public class AdminDao {
	private final String SQL_UPDATE_ROOM_DETAILS="insert into room_details(room_id,room_type,capacity,date)values(?,?,?,?)";
	private final String SQL_GET_ADMIN_DETAILS = "select admin_id,name,password from admin where name=?";
	private final String SQL_GET_BOOKING_ROOM_DETAILS="select room_id,no_of_guest,room_type,check_in_date,check_out_date from booking_room_details where check_in_date between ? and ?";
	//private final String SQL_GET_BOOKING_ROOM_DETAILS="select room_id,no_of_guest,room_type,check_in_date,check_out_date from booking_room_details";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 public AdminBo findAdmin(String name) {
			try {
						return jdbcTemplate.queryForObject(SQL_GET_ADMIN_DETAILS,(rs,rowNum)->{
							AdminBo adminbo=new AdminBo(rs.getInt(1),rs.getString(2),rs.getString(3));
							return adminbo;
						},name);
			}catch(Exception e) {
				throw new AdminNotFoundException("admin not identified");
			}
	 }
	 public void updateRoomDetails(RoomDetailsBo bo) {
	 jdbcTemplate.update((con)->{
		  PreparedStatement pstmt=con.prepareStatement(SQL_UPDATE_ROOM_DETAILS);
		   pstmt.setInt(1, bo.getRoomId());
		   pstmt.setString(2, bo.getRoomType());
		   pstmt.setInt(3,bo.getCapacity());
		   pstmt.setDate(4, bo.getDate());
		  
		  return pstmt;
		  
	  });
	 }
	 public List<BookingRoomDetailsBo> getBookingRoomDetails(Date fromDate,Date toDate) {
		/*
		 * MapSqlParameterSource parameters = new MapSqlParameterSource();
		 * parameters.addValue("fDate",fromDate); parameters.addValue("tDate", toDate);
		 */
		 return jdbcTemplate.query(SQL_GET_BOOKING_ROOM_DETAILS,(rs,rowNum)->{
			 BookingRoomDetailsBo bo=new BookingRoomDetailsBo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getDate(5));
				return bo;
			},fromDate,toDate);
	 }
}
