package com.far.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.far.dto.CouponDTO;
import com.far.dto.ResvDTO;
import com.far.service.MyPageService;

@Controller
@RequestMapping("/my_page")
public class MyPageControlller {
	
	@Autowired
	private MyPageService myPageService;

	@RequestMapping("/chkResv")
	public ModelAndView chkresv(HttpSession session) {
		String memId = (String)session.getAttribute("memId");
		List<ResvDTO> resvList = myPageService.getResvList(memId);
		ModelAndView mav = new ModelAndView("myPage/chkReservation");
		mav.addObject("resvList", resvList);
		return mav;
	}
}
