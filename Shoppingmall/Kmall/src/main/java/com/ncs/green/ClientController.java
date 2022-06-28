package com.ncs.green;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ClientService;
import vo.ClientVO;

@Controller
public class ClientController {
	
	@Autowired 
	ClientService service;
	
	// 로그인 폼
	@RequestMapping(value = "/clientloginf", method = RequestMethod.GET)
	public ModelAndView clientloginf(ModelAndView mv) {
		mv.setViewName("client/clientLoginForm");
		return mv;
	} // clientloginf

	// 로그인 기능
	@RequestMapping(value = "/clientlogin")
	public ModelAndView clientlogin(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, ClientVO vo,
			RedirectAttributes rttr) throws IOException {
		// 한글처리
		response.setContentType("text/html; charset=UTF-8");

		// 요청분석
		String password = vo.getPassword1();
		PrintWriter out = response.getWriter();

		// Service
		vo = service.selectClientOne(vo);
		if (vo != null) {
			// 아이디 확인완료(일치)
			if (vo.getPassword1().equals(password)) {
				// 아이디, 비밀번호 확인완료(일치) => 로그인 성공

				// 로그인 성공 => id, name session 객체 생성 후 보관 => home
				HttpSession session = request.getSession(true);
				session.setAttribute("LoginID", vo.getId());
				session.setAttribute("LoginName", vo.getName());
				// 1.redirect:가 붙지 않으면 servlet-context.xml에서 InternalResourceViewResolver가 
				// 설정한 prefix와 suffix 정보가 적용된 .jsp 파일을 찾고, 
				// 2.redirect:가 붙으면 InternalResourceViewResolver 설정 정보는 무시되고 Context path 위치에서 .jsp 파일을 찾는다.
				// 예를들어서 mv.setViewName("home");로 되어 있으면 http://localhost/Kmall/WEB-INF/views/home.jsp를 찾게 되고
				// mv.setViewName("redirect:home");로 되어 있으면
				// http://localhost/Kmall/home.jsp를 찾게 된다.
				mv.setViewName("redirect:home");
			} else {
				// 비밀번호 일치하지 않음
				out.println("<script>alert('아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요.');</script>");
				mv.setViewName("client/clientLoginForm");
				out.flush();
			}
		} else {
			// 아이디가 일치하지 않음
			out.println("<script>alert('아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요.');</script>");
			mv.setViewName("client/clientLoginForm");
			out.flush();
		} 
		// view
		return mv;
	} // clientlogin
	
	// 회원가입
	@RequestMapping(value = "/clientjoinf", method=RequestMethod.GET)
	public ModelAndView clientjoinf(ModelAndView mv) {
		mv.setViewName("client/clientJoinForm");
		return mv;
	} // clientjoinf
	
	@RequestMapping(value = "/clientjoin", method=RequestMethod.POST)
	public ModelAndView clientjoin(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, ClientVO vo) throws IOException {
		// 한글처리
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("> 회원가입 입력정보 : " + vo);
		
		// Service
		if (service.insertClient(vo) > 0) {
			// 회원가입 성공으로 로그인페이지로 이동
			mv.setViewName("client/clientLoginForm");
		}else {
			// 회원가입 실패로 회원가입페이지 이동
			mv.setViewName("client/clientJoinForm");
		}
		
		// view
		return mv;
	} // clientjoin
	
	// 아이디 중복확인
	@RequestMapping(value = "/idDoubleCheck", method = RequestMethod.GET)
	public ModelAndView idDoubleCheck(ModelAndView mv, ClientVO vo) {
		// 입력한 newId 보관
		mv.addObject("newID", vo.getId());
		
		vo = service.selectClientOne(vo);
		
		if (vo != null) {
			// 아이디가 이미 존재하면 사용불가
			mv.addObject("idUse", "F");
		} else {
			// 아이디가 존재하지 않으면 사용가능
			mv.addObject("idUse", "T");
		}
		mv.setViewName("client/idDoubleCheck");
		return mv;
	} // idDoubleCheck
	
} // ClientController