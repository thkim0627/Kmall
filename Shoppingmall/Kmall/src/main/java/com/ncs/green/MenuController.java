package com.ncs.green;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {
	
	// 검색 폼
	@RequestMapping(value = "/menusearch", method = RequestMethod.GET)
	public ModelAndView menusearch(ModelAndView mv) {
		mv.setViewName("menu/menuSearch");
		return mv;
	} // menusearch
	
	// 접촉정보
	@RequestMapping(value = "/menucontact", method = RequestMethod.GET)
	public ModelAndView menucontact(ModelAndView mv) {
		mv.setViewName("menu/menuContact");
		return mv;
	} // menucontact
	
} // MenuController