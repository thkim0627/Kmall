package com.ncs.green;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	
	// 전체 상품 페이지
	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public ModelAndView shop(ModelAndView mv) {
		mv.setViewName("goods/shop");
		return mv;
	} // shop
	
	@RequestMapping(value = "/outer", method = RequestMethod.GET)
	public ModelAndView outer(ModelAndView mv) {
		mv.setViewName("goods/outer");
		return mv;
	} // outer
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public ModelAndView top(ModelAndView mv) {
		mv.setViewName("goods/top");
		return mv;
	} // top

	@RequestMapping(value = "/bottom", method = RequestMethod.GET)
	public ModelAndView bottom(ModelAndView mv) {
		mv.setViewName("goods/bottom");
		return mv;
	} // bottom
	
	@RequestMapping(value = "/onepiece", method = RequestMethod.GET)
	public ModelAndView onepiece(ModelAndView mv) {
		mv.setViewName("goods/onepiece");
		return mv;
	} // onepiece
	
	@RequestMapping(value = "/skirt", method = RequestMethod.GET)
	public ModelAndView skirt(ModelAndView mv) {
		mv.setViewName("goods/skirt");
		return mv;
	} // skirt
	
	@RequestMapping(value = "/shoes", method = RequestMethod.GET)
	public ModelAndView shoes(ModelAndView mv) {
		mv.setViewName("goods/shoes");
		return mv;
	} // shoes
	
	@RequestMapping(value = "/bag", method = RequestMethod.GET)
	public ModelAndView bag(ModelAndView mv) {
		mv.setViewName("goods/bag");
		return mv;
	} // bag
	
	@RequestMapping(value = "/headwear", method = RequestMethod.GET)
	public ModelAndView headwear(ModelAndView mv) {
		mv.setViewName("goods/headwear");
		return mv;
	} // headwear
	
	@RequestMapping(value = "/underwear", method = RequestMethod.GET)
	public ModelAndView underwear(ModelAndView mv) {
		mv.setViewName("goods/underwear");
		return mv;
	} // underwear
	
	@RequestMapping(value = "/atc", method = RequestMethod.GET)
	public ModelAndView atc(ModelAndView mv) {
		mv.setViewName("goods/atc");
		return mv;
	} // atc

	@RequestMapping(value = "/etc", method = RequestMethod.GET)
	public ModelAndView etc(ModelAndView mv) {
		mv.setViewName("goods/etc");
		return mv;
	} // etc
	
	// 세일 페이지
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public ModelAndView sale(ModelAndView mv) {
		mv.setViewName("goods/sale");
		return mv;
	} // sale
	
} // GoodsController