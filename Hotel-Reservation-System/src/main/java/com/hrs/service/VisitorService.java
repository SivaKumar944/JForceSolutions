package com.hrs.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.bo.VisitorLoginBo;
import com.hrs.bo.VisitorRegBo;
import com.hrs.dao.VisitorDao;
import com.hrs.exception.VisitorNotFoundExeption;
@Service
public class VisitorService {
	@Autowired
	VisitorDao dao;
	
	public int saveVisitorDetails(VisitorRegBo regBo) {
		return dao.saveVisitorDetails(regBo);
	}
	public boolean validateVisitorUserNameAndPassword(VisitorLoginBo loginBo) {
		boolean msg=false;
		VisitorRegBo bo=null;
		try {
		bo=dao.findVisitor(loginBo);
		}catch (VisitorNotFoundExeption e) {
			msg=false;
		}
		
		if(bo!=null) {
		String password=bo.getPassword();
		if(password!=null && password.equals(loginBo.getPassword())) {
			msg=true;
			
		}
		
		}
		return msg;
	}
	public void saveRoomDetails(BookingRoomDetailsBo bo) {
		dao.saveRoomDetails(bo);
	}
	public List<RoomDetailsBo> getRoomDetailsBos(Date cid,Date cod){
		return dao.getRoomDetails(cid, cod);
	}

}
