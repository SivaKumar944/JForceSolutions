package com.hrs.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrs.bo.BookingRoomDetailsBo;
import com.hrs.bo.RoomDetailsBo;
import com.hrs.service.AdminService;

@Controller
@RequestMapping("/admin.htm")
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping
	public String findAdmin(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		boolean flag = adminService.findAdminorNot(name, password);
		if (flag) {
			return "admin";
		} else {
			model.addAttribute("val", 1);
			return "admin-login";
		}

	}

	@PostMapping("/updateroomdetails.htm")
	public String updateRoomDetails(@ModelAttribute("updateRoomDetails") RoomDetailsBo bo) {
		adminService.updateRoomDetails(bo);
		return "update-room-details-success";
	}

	@GetMapping("/getbookingdetails.htm")
	public String getBookingRoomDetails(@RequestParam("fromDate") Date fDate, @RequestParam("toDate") Date tDate,
			Model model) {
		List<BookingRoomDetailsBo> brdb=adminService.getBookingRoomDetails(fDate, tDate);
		model.addAttribute("listbookingroomdetails", brdb);
		return "visitor-booking-room-details";
	}
}
