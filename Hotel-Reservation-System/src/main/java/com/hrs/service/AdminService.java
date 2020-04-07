package com.hrs.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.bo.AdminBo;
import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.dao.AdminDao;
import com.hrs.exception.AdminNotFoundException;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;

	public boolean findAdminorNot(String name, String inpassword) {
		boolean flag = false;
		AdminBo adminBo = null;
		try {
			adminBo = adminDao.findAdmin(name);
		} catch (AdminNotFoundException e) {
			flag = false;
		}

		if (adminBo != null) {
			String dbpassword = adminBo.getPassword();
			if (dbpassword != null && dbpassword.equals(inpassword)) {
				flag = true;
			}
		}
		return flag;

	}

	public void updateRoomDetails(RoomDetailsBo bo) {
		adminDao.updateRoomDetails(bo);
	}

	public List<BookingRoomDetailsBo> getBookingRoomDetails(Date fromDate, Date toDate) {
		return adminDao.getBookingRoomDetails(fromDate, toDate);
	}

}
