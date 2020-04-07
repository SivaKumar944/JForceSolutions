package com.hrs.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.bo.VisitorLoginBo;
import com.hrs.bo.VisitorRegBo;
import com.hrs.service.VisitorService;
import com.hrs.validator.VisitorRegBoValidator;

@Controller
@RequestMapping("/visitor-reg.htm")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;

	@Autowired	
	private VisitorRegBoValidator validator;
	
	@GetMapping
	public String validateVisitorUserNameAndPassword(@ModelAttribute("visitorLogin") VisitorLoginBo  loginBo,Errors errors, Model model) {
		boolean msg=visitorService.validateVisitorUserNameAndPassword(loginBo);
		if(msg) {
		return "search-rooms";
		}
		else{
		model.addAttribute("val",1);
		return "visitor-login";
		}
		
	}

	@PostMapping
	public String saveVisitorRegDetails(@ModelAttribute("visitorBo") VisitorRegBo  bo, Errors errors, Model model) {
		/*
		 * if (validator.supports(VisitorRegBo.class)) { validator.validate(bo, errors);
		 * if (errors.hasErrors()) { return "visitor-reg"; } }
		 */
		int visitorId = 0;
		visitorId = visitorService.saveVisitorDetails(bo);
		model.addAttribute("visitorId", visitorId);
		return "visitor-reg-success";
	}
	@PostMapping("/book-room.htm")
	public String saveBookDetails(@ModelAttribute("roomDetails") BookingRoomDetailsBo bookingRoomDetailsBo,Model model) {
		visitorService.saveRoomDetails(bookingRoomDetailsBo);
		return "booking-success";
	}
	@GetMapping("/getroomdetails.htm")
	public String getRoomDetails(@RequestParam("checkInDate") Date cid,@RequestParam("checkOutDate") Date cod,Model model) {
		List<RoomDetailsBo> bo=visitorService.getRoomDetailsBos(cid, cod);
		model.addAttribute("listroomdetails",bo);
		return "search-rooms";
	}
	
}


