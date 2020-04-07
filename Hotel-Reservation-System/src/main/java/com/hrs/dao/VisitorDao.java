package com.hrs.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.bo.VisitorLoginBo;
import com.hrs.bo.VisitorRegBo;
import com.hrs.exception.VisitorNotFoundExeption;
@Repository
public class VisitorDao {
	private final String SQL_INSERT_VISITOR_DETAILS="insert into visitor_details(visitor_name,password,email_address,mobile_nbr)values(?,?,?,?)";
	private final String SQL_FIND_VISITOR="select visitor_id,visitor_name,password,email_address,mobile_nbr from visitor_details where email_address=?";
	private final String SQL_INSERT_ROOM_DETAILS="insert into booking_room_details(room_id,no_of_guest,room_type,check_in_date,check_out_date)values(?,?,?,?,?)";
	private final String SQL_GET_ROOM_DETAILS="select room_id,room_type,capacity,date from room_details where date between ? and ? ";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 public int saveVisitorDetails(VisitorRegBo bo) {
		  int visitorId=0;
		  KeyHolder kh=new GeneratedKeyHolder();
		  jdbcTemplate.update((con)->{
			  PreparedStatement pstmt=con.prepareStatement(SQL_INSERT_VISITOR_DETAILS,new String[] {"visitor_id"});
			   pstmt.setString(1, bo.getVisitorName());
			   pstmt.setString(2, bo.getPassword());
			   pstmt.setString(3,bo.getEmailAddress());
			   pstmt.setString(4, bo.getMobileNumber());
			  
			  return pstmt;
			  
		  },kh);
		  visitorId=kh.getKey().intValue();
		  return visitorId;
	  }
	 public VisitorRegBo findVisitor(VisitorLoginBo bo) {
	try {
				return jdbcTemplate.queryForObject(SQL_FIND_VISITOR,(rs,rowNum)->{
					VisitorRegBo regbo=new VisitorRegBo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					return regbo;
				},bo.getEmailAddress());
	}catch (Exception e) {
		throw new VisitorNotFoundExeption("visitor not identified") ;
	}
				
			}
	 public void saveRoomDetails(BookingRoomDetailsBo  bookingRoomDetailsBo) {
		 jdbcTemplate.update((con)->{
			  PreparedStatement pstmt=con.prepareStatement(SQL_INSERT_ROOM_DETAILS);
			   pstmt.setInt(1, bookingRoomDetailsBo.getRoomId());
			   pstmt.setInt(2, bookingRoomDetailsBo.getNoOfGuest());
			   pstmt.setString(3, bookingRoomDetailsBo.getRoomType());
			   pstmt.setDate(4,bookingRoomDetailsBo.getCheckInDate());
			   pstmt.setDate(5,bookingRoomDetailsBo.getCheckOutDate());
			   
			  
			  return pstmt;
			  
		  });
	 }
	 public List<RoomDetailsBo> getRoomDetails(Date cid,Date cod) {
		 return jdbcTemplate.query(SQL_GET_ROOM_DETAILS,(rs,rowNum)->{
				RoomDetailsBo bo=new RoomDetailsBo(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4));
				return bo;
			},cid,cod);
	 }
}


