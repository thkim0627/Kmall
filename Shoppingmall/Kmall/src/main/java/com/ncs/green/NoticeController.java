package com.ncs.green;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.NoticeService;
import vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	NoticeService service ;
	
	// 공지사항 
	// 조회
	@RequestMapping(value = "/noticelist", method=RequestMethod.GET)
	public ModelAndView noticelist(ModelAndView mv) {
		// 요청분석 & Service
		mv.addObject("notice", service.noticeList());
		// View
		mv.setViewName("notice/noticeList");
		return mv;
	} // noticelist
	
	// 조회 - 페이징
	
	// 상세보기 - 조회수
	@RequestMapping(value = "/noticedetail", method=RequestMethod.GET)
	public ModelAndView noticedetail(HttpServletRequest request, HttpServletResponse response,
								RedirectAttributes rttr, ModelAndView mv, NoticeVO vo) {
		// 요청분석 & Service
		// 조회수 증가 
		// Cookie를 이용해서 24시간 동안 동일한 글은 1회만 증가 가능 하도록 한다.
		// 단, 로그인 여부는 무관하게 상세글 보기가 가능 하므로 client의 id는 따지지 않는다.
		
		// 쿠기 생성
		Cookie viewCookie = null;
		Cookie[] cookies = request.getCookies();
		
		// 현재 글의 조회수 증가 반영 확인 후 없을때만 증가
		if (cookies != null) {
			for (Cookie c:cookies) {
				if (c.getName().equals("|"+vo.getSeq()+"|")) {   //  쿠키의 보관 값 (seq)
					// 일치하는 글번호 존재하면 조회수는 증가하지않는다. 
					viewCookie = c;
					break;
				}
			} 
		}
		
		// 그러므로 viewCookie가 null인 경우에만 Cookie 보관, 조회수 증가 처리
		if (viewCookie == null) {
			// 조회수증가 처리 성공후 Cookie 처리
			if (service.countUp(vo) > 0) {
				Cookie newCookie = new Cookie("|"+vo.getSeq()+"|","view") ;
				newCookie.setMaxAge(24*60*60);  // MaxAge 24시간 지정 (단위 초)
				response.addCookie(newCookie);
			} else {
				System.out.println("> 조회수 증가가 정상적으로 처리되지 않았습니다. <");
			}
		} 
		
		vo = service.noticeOne(vo);
		// MyBatis 적용시에는 중간객체를 거쳐 전달되기때문에 vo에 결과를 담아야한다.
		if (vo != null) {
			// 상세보기
			mv.addObject("noticeDetail", vo);
			mv.setViewName("notice/noticeDetail");
		}else {
			// 다시 noticeList로 이동
			rttr.addFlashAttribute("message", "> 글번호에 해당하는 자료가 없습니다. <");
			mv.setViewName("redirect:noticelist");
		}
				
		// View
		return mv;
	} // noticedetail
	
	// 작성 폼
	@RequestMapping(value = "/noticeinsertf", method=RequestMethod.GET)
	public ModelAndView noticeinsertf(ModelAndView mv) {
		mv.setViewName("notice/noticeInsertForm");
		return mv;
	} // noticeinsertf

	// 작성
	@RequestMapping(value = "/noticeinsert", method=RequestMethod.POST)
	public ModelAndView noticeinsert(ModelAndView mv, NoticeVO vo, RedirectAttributes rttr) {
		// 요청분석 & Service
		// 글작성 성공 : noticelist, 실패 : noticeInsertForm
		if (service.noticeInsert(vo) > 0) {
			// 성공
			rttr.addFlashAttribute("message", "> 새로운 글을 등록하는데 성공했습니다. <");
			mv.setViewName("redirect:noticelist");
		}else {
			// 실패
			mv.addObject("message", "> 새로운 글을 등록하는데 실패했습니다. <");
			mv.setViewName("notice/noticeInsertForm");
		}
		// View
		return mv;
	} // noticeinsert
	
	// 수정 폼
	@RequestMapping(value = "/noticeupdatef", method=RequestMethod.GET)
	public ModelAndView noticeupdatef(ModelAndView mv, NoticeVO vo, RedirectAttributes rttr) {
		// 요청분석 & Service
		vo = service.noticeOne(vo);
		// MyBatis 적용시에는 중간객체를 거쳐 전달되기때문에 vo에 결과를 담아야한다.
		if (vo != null) {
			// 수정 폼 이동 성공
			mv.addObject("noticeUpdate", vo);
			mv.setViewName("notice/noticeUpdateForm");
		} else  {
			// // 수정 폼 이동 실패
			rttr.addFlashAttribute("message", "> 글번호의 해당하는 자료를 불러오는데 실패했습니다. <");
			mv.setViewName("redirect:noticelist");
		}
		// View
		return mv;
	} // noticeupdatef
	
	// 수정
	@RequestMapping(value = "/noticeupdate", method=RequestMethod.POST)
	public ModelAndView noticeupdate(ModelAndView mv, NoticeVO vo, RedirectAttributes rttr) {
		// 요청분석 & Service
		if (service.noticeUpdate(vo) > 0) {
			// 수정 성공
			rttr.addFlashAttribute("message", "> 작성한 글을 수정하는데 성공했습니다. <");
			mv.setViewName("redirect:noticelist");
		} else  {
			// 수정 실패 
			rttr.addFlashAttribute("message", "> 작성한 글을 수정하는데 실패했습니다. <");
			mv.setViewName("redirect:noticeupdatef?seq="+ vo.getSeq());
		}
		// View
		return mv;
	} //noticeupdate
	
	// 삭제
	@RequestMapping(value = "/noticedelete", method=RequestMethod.GET)
	public ModelAndView noticedelete(ModelAndView mv, NoticeVO vo, RedirectAttributes rttr) {
		// 요청분석 & Service
		if (service.noticeDelete(vo) > 0) {
			// 삭제 성공
			rttr.addFlashAttribute("message", "> 작성한 글을 삭제하는데 성공했습니다. <");
			mv.setViewName("redirect:noticelist");
		}else {
			// 삭제 실패
			rttr.addFlashAttribute("message", "> 작성한 글을 삭제하는데 실패했습니다. <");
			mv.setViewName("redirect:noticedetail?seq="+vo.getSeq());
		}
		// View
		return mv;
	} // noticedelete
	
} // class