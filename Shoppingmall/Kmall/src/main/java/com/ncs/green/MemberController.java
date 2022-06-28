package com.ncs.green;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.MemberService;
import vo.MemberVO;

// ** Bean 생성하는 @
// Java : @Component
// Spring 세분화 됨
// => @Controller,  @Service,  @Repository

@Controller
public class MemberController {
	@Autowired 
	// 자동주입 (injection)
	// => 조건: 주입받으려는 구현 클래스가 반드시 생성되어있어야함. 
	MemberService service;
	//MemberService service = new MemberServiceImpl();
	
	// ** jsonView Login Test
	@RequestMapping(value = "/jslogin")
	public ModelAndView jslogin(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, MemberVO vo) {
		// 1. 요청분석
		// => 입력한 password 보관
		String password = vo.getPassword();
		
		// => response 한글처리
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. Service
		vo = service.selectOne(vo);
		if ( vo!=null ) {
			// id 성공 -> password 확인
			if ( vo.getPassword().equals(password) ) {
				// Login 성공 -> Login정보(id,name) 보관 -> reload
				HttpSession session = request.getSession(true);
				session.setAttribute("LoginID",vo.getId()); 
				session.setAttribute("LoginName",vo.getName());
				mv.addObject("code", "200");
			}else {
				// password 오류 -> LoginForm
				mv.addObject("code", "201");
				mv.addObject("message", "~~ password 오류 !! 다시 하세요 ~~");
			}
		}else {
			// id 오류 -> LoginForm
			mv.addObject("code", "201");
			mv.addObject("message", "~~ id 오류 !! 다시 하세요 ~~");
		}
		// 3. 결과 : view 처리
		mv.setViewName("jsonView");
		return mv;
	} // jslogin
	
	
// *** Image (File) Download
	@RequestMapping(value = "/dnload")
	public ModelAndView dnload(HttpServletRequest request, ModelAndView mv, 
			@RequestParam("dnfile") String dnfile ) {
		   // => 동일기능 : String dnfile = request.getParameter("dnfile");
		
		// 1. File Download
		// => real path 확인 -> 해당화일선택 -> response 처리 (response의 body 에 담아줌) 
		
		String realPath = request.getRealPath("/"); // deprecated Method
		String fileName = dnfile.substring(dnfile.lastIndexOf("/")+1); // dnfile => resources\\uploadImage\\aaa.gif 
		
		// => 개발중인지, 배포했는지 에 따라 결정
		// => 해당화일 File 찾기
		if ( realPath.contains(".eclipse.") )  // eslipse 개발환경 (배포전)
			realPath = "C:/Development/MTest/MyWork/Spring01/src/main/webapp/resources/uploadImage/" 
						+ fileName;
		else  // 톰캣서버에 배포 후 : 서버내에서의 위치
			realPath += "resources\\uploadImage\\" + fileName ;
		
		// => 해당화일 File 객체화 
		File file = new File(realPath);
		mv.addObject("downloadFile", file);
		
		// 2. 결과 view처리 : Java File 객체 -> File 정보를 response 에 전달
		mv.setViewName("downloadView");
		// ** 일반적인 경우 ~/views/downloadView.jsp 를 찾음, 그러나 이 경우에는 아님
		// => servlet-context.xml 에 설정하는 view 클래스 (DownloadView.java) 의
		//    id 와 동일 해야함.
		
		return mv;
	} //dnload
	
	// ** 위 addOb.. , setView.., return..  3 구문은 아래처럼 작성도 가능.
	// => return new ModelAndView("downloadView", "downloadFile", file);
	// => 생성자 참고 
	//    public ModelAndView(View view, String modelName, Object modelObject) { 
	//     		this.view = view; addObject(modelName, modelObject); }
	

// *** JSON 제이슨, (JavaScript Object Notation) **********
// => 자바스크립트의 객체 표기법으로, 데이터를 전달 할 때 사용하는 표준형식.
//    속성(key) 과 값(value) 이 하나의 쌍을 이룸
		
// ** JAVA의 Data 객체 -> JSON 변환하기
// 1) GSON
// : 자바 객체의 직렬화/역직렬화를 도와주는 라이브러리 (구글에서 만듦)
// 즉, JAVA객체 -> JSON 또는 JSON -> JAVA객체
		
// 2) @ResponseBody (매핑 메서드에 적용)
// : 메서드의 리턴값이 View 를 통해 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됨.
// 이때 쓰여지기전, 리턴되는 데이터 타입에 따라 종류별 MessageConverter에서 변환이 이뤄진다.
// MappingJacksonHttpMessageConverter 를 사용하면 request, response 를 JSON 으로 변환
// view (~.jsp) 가 아닌 Data 자체를 전달하기위한 용도
// @JsonIgnore : VO 에 적용하면 변환에서 제외

// 3) jsonView
// => Spring 에서 MappingJackson2JsonView를 사용해서
// ModelAndView를 json 형식으로 반환해 준다.
// => 방법
// -> pom dependency추가 , 설정화일 xml 에 bean 등록
// -> return할 ModelAndView 생성시 View를 "jsonView"로 설정
	
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	//** Ajax Member Delete 
	@RequestMapping(value = "/axmdelete")
	public ModelAndView axmdelete(HttpServletRequest request, ModelAndView mv, MemberVO vo) {
		// 1. 요청분석 & Service
		HttpSession session = request.getSession(false); 
		if ( session!=null && ((String)session.getAttribute("LoginID")).equals("admin")) {
			// 삭제가능
			if ( service.delete(vo) > 0 ) {
				// 삭제성공   
				mv.addObject("code", "200");
			}else {
				// 삭제실패 -> 서버오류  
				mv.addObject("code", "201");
			}
		}else {
			// 삭제 불가능 -> 로그인 정보 없음  
			mv.addObject("code", "202");
		}
		// 2. 결과 view처리 : Java 객체 -> JSON 
		mv.setViewName("jsonView");
		return mv;
	} //axmdelete
	
	//** Ajax_MemberList
	@RequestMapping(value = "/axmlist", method=RequestMethod.GET)
	public ModelAndView axmlist(ModelAndView mv) {
		mv.addObject("banana", service.selectList());        
		mv.setViewName("axTest/axMemberList");
		return mv;
	} //axmlist
	
//	//** ID 중복 확인
//	@RequestMapping(value = "/idDupCheck", method=RequestMethod.GET)
//	public ModelAndView idDupCheck(ModelAndView mv, MemberVO vo) {
//		// 입력한 newID 보관
//		mv.addObject("newId", vo.getId());
//		vo = service.selectOne(vo);
//		if ( vo!=null ) { 
//			// id 존재 -> 사용불가능
//			mv.addObject("idUse", "F");
//		}else {
//			// id 존재하지 않음 -> 사용가능
//			mv.addObject("idUse", "T");
//		}
//		mv.setViewName("member/idDupCheck");
//		return mv;
//	} //idDupCheck
	
	// 1-1.로그인폼으로 이동
	@RequestMapping(value = "/loginf", method=RequestMethod.GET)
	public ModelAndView loginf(ModelAndView mv) {
		mv.setViewName("member/loginForm");
		return mv;
	} //loginf
	
	// 1-2.로그인기능 구현
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, MemberVO vo, RedirectAttributes rttr) throws IOException {
		// 0.한글처리
		response.setContentType("text/html; charset=UTF-8");

		// 1.요청분석
		String password = vo.getPassword();
		PrintWriter out = response.getWriter();
		
		// 2.Service
		vo = service.selectOne(vo);
		if (vo != null) { 
			// 아이디 확인완료(일치)
			if (vo.getPassword().equals(password)) { 
				// 아이디, 비밀번호 확인완료(일치) => 로그인 성공
				
				// 로그인 성공 => id, name session 객체 생성 후 보관 => home
				HttpSession session = request.getSession(true); 
				session.setAttribute("LoginID", vo.getId());  
				session.setAttribute("LoginName", vo.getName());
				// 1.redirect:가 붙지 않으면 servlet-context.xml에서 InternalResourceViewResolver가 
				//   설정한 prefix와 suffix 정보가 적용된 .jsp 파일을 찾고, 
				// 2.redirect:가 붙으면 InternalResourceViewResolver 설정 정보는 무시되고 Context path 위치에서 .jsp 파일을 찾는다.
				//   예를들어서 mv.setViewName("home");로 되어 있으면 http://localhost/Kmall/WEB-INF/views/home.jsp를 찾게 되고 
				//   mv.setViewName("redirect:home");로 되어 있으면 http://localhost/Kmall/home.jsp를 찾게 된다.
				mv.setViewName("redirect:home");
			} else {
				// 비밀번호 일치하지 않음
				out.println("<script>alert('아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요.');</script>"); 
				mv.setViewName("member/loginForm");
				out.flush();
			}
		} else {
			// 아이디 일치하지 않음
			// location.href='loginf';
			out.println("<script>alert('아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요.');</script>"); 
			mv.setViewName("member/loginForm");
			out.flush();
		}
		// 3.view 처리
		return mv;
	} //login
	
	@RequestMapping(value = "/logout") 
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv, RedirectAttributes rttr) {
		// 1. Logout => session 무효화
		request.getSession().invalidate(); 
	
		// 2. 결과(View) 처리
		//mv.addObject("message", "~~ Logout 성공 ~~");
		rttr.addFlashAttribute("message", "~~ Logout 성공 ~~");
		mv.setViewName("redirect:home");
		return mv;
	} //logout
	
	//** 2. Join
	@RequestMapping(value = "/joinf", method=RequestMethod.GET)
	public ModelAndView joinf(ModelAndView mv) {
		mv.setViewName("member/joinForm");
		return mv;
	} //joinf
	
	//@RequestMapping(value = "/join", method=RequestMethod.GET)
	// => 405: Request method 'POST' not supported
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public ModelAndView join(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, MemberVO vo) throws IOException {
		
		// 한글처리
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("***** vo => "+vo);
		
		// 1. 요청분석
		// 1.1) Upload Image 처리
		// => image file 저장위치 결정 -> 저장 -> 저장위치를 vo 에 set
		// => 이 작업을 도와주는 객체 : MultipartFile
		
		// ** MultipartFile
		// => MultipartFile 타입의 uploadfilef 의 정보에서 
		//    upload된 image 화일과 화일명을 get 처리,
		// => upload된 image 화일은 서버의 정해진 폴더 (물리적위치)에 저장 하고, -> file1
		// => 이 위치에 대한 정보를 table에 저장 (vo의 UploadFile 에 set) -> file2
		// ** image 화일명 중복시 : 나중 이미지로 update 됨. 
		
		// ** Image 물리적위치 에 저장
		// 1) 현재 웹어플리케이션의 실행 위치 확인 : 
		// => eslipse 개발환경 (배포전)
		//    D:\MTest\MyWork\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\Spring01\
		// => 톰캣서버에 배포 후 : 서버내에서의 위치가 됨
		//    D:\MTest\IDESet\apache-tomcat-9.0.41\webapps\Spring01\
		String realPath = request.getRealPath("/"); // deprecated Method
		System.out.println("** realPath => "+realPath);
		
		// 2) 위 의 값을 이용해서 실제저장위치 확인 
		// => 개발중인지, 배포했는지 에 따라 결정
		if ( realPath.contains(".eclipse.") )  // eslipse 개발환경 (배포전)
			realPath = "C:/Development/MTest/MyWork/Spring01/src/main/webapp/resources/uploadImage/";
		else  // 톰캣서버에 배포 후 : 서버내에서의 위치
			realPath += "resources\\uploadImage\\" ;
		
		// ** 폴더 만들기 (File 클래스활용)
		// => 위의 저장경로에 폴더가 없는 경우 (uploadImage가 없는경우)  만들어 준다
		File f1 = new File(realPath);
		if ( !f1.exists() ) f1.mkdir();
		// => realPath 디렉터리가 존재하는지 검사 (uploadImage 폴더 존재 확인)
		//    존재하지 않으면 디렉토리 생성
		
		// ** 기본 이미지 지정하기 
		String file1, file2="resources/uploadImage/basicman4.jpg"; 
		
		// ** MultipartFile
		// => 업로드한 파일에 대한 모든 정보를 가지고 있으며 이의 처리를 위한 메서드를 제공한다.
		//    -> String getOriginalFilename(), 
		//    -> void transferTo(File destFile),
		//    -> boolean isEmpty()
		
		MultipartFile uploadfilef = vo.getUploadfilef();
		if ( uploadfilef !=null && !uploadfilef.isEmpty() ) {
			
			// ** Image를 선택함 -> Image저장 ( 경로_realPath + 화일명 )
			// 1) 물리적 저장경로에 Image저장
			file1 = realPath + uploadfilef.getOriginalFilename(); // 경로완성
			uploadfilef.transferTo(new File(file1)); // Image저장
			
			// 2) Table 저장 준비
			file2="resources/uploadImage/"+uploadfilef.getOriginalFilename();
		}
		// ** 완성된 경로 vo 에 set
		vo.setUploadfile(file2);
		
		// 2. Service
		if ( service.insert(vo) > 0 ) {
			// 입력성공 -> loginForm 으로 
			mv.addObject("message", "~~ 회원가입 완료 -> 로그인후 이용 하세요 ~~");
			mv.setViewName("member/loginForm");
		}else {
			// 입력실패 -> 재시도 유도 joinForm 으로
			mv.addObject("message", "~~ 회원가입 오류 -> 다시 하세요 ~~");
			mv.setViewName("member/joinForm");
		}
		// 3. 결과 : view 처리
		return mv;
	} //join
	
	//** 3. MemberList
	@RequestMapping(value = "/mlist")
	public ModelAndView mlist(ModelAndView mv) {
		// 1. 요청분석 & Service
		mv.addObject("banana", service.selectList());
		mv.setViewName("member/memberList");
		
		// 2. 결과 : view 처리
		return mv;
	} //mlist
	
	//** 4. MemberDetail
	@RequestMapping(value = "/mdetail")
	public ModelAndView mdetail(HttpServletRequest request, ModelAndView mv, MemberVO vo) {
		// 1. 요청분석 & Service
		
		HttpSession session = request.getSession(false);  
		if ( session!=null && session.getAttribute("LoginID")!=null ) {
			 
			vo.setId((String)session.getAttribute("LoginID"));
			vo = service.selectOne(vo);
			if ( vo!=null ) { 
				// => vo를 View가 출력 가능하도록 담고 View 지정
				request.setAttribute("apple", vo);
				// => Detail or Update 확인 
				if ( request.getParameter("jcode")!=null && request.getParameter("jcode").equals("U") )  
					 mv.setViewName("member/updateForm");
				else mv.setViewName("member/memberDetail");
				
			}else {
				// => user 정보 읽어오는데 실패 -> 재로그인 유도 ( loginForm.jsp ) 
				mv.addObject("message", "~~ vo null: 개인정보 읽어오기 실패 !! ~~");
				mv.setViewName("member/loginForm");
			} // vo
		}else {
			// 로그인정보가 없음을 알려준다 -> 재로그인 유도 ( loginForm.jsp )
			mv.addObject("message", "~~ session null: 로그인 정보가 없습니다 !! ~~");
			mv.setViewName("member/loginForm");
		} // session_if-else
		
		// 2. 결과 : view 처리
		return mv;
	} //mdetail
	
	//** 7. Member Update
	@RequestMapping(value = "/mupdate", method=RequestMethod.POST)
	public ModelAndView mupdate(HttpServletRequest request, 
							ModelAndView mv, MemberVO vo) throws IOException {
		// 1. 요청분석
		// 1.1) Upload Image 처리
		
		// ** 저장경로 찾기
		String realPath = request.getRealPath("/"); // deprecated Method
		if ( realPath.contains(".eclipse.") )  // eslipse 개발환경 (배포전)
			realPath = "C:/Development/MTest/MyWork/Spring01/src/main/webapp/resources/uploadImage/";
		else  // 톰캣서버에 배포 후 : 서버내에서의 위치
			realPath += "resources\\uploadImage\\" ;
		
		// ** 폴더 만들기 (File 클래스활용)
		// => 위의 저장경로에 폴더가 없는 경우 (uploadImage가 없는경우)  만들어 준다
		File f1 = new File(realPath);
		if ( !f1.exists() ) f1.mkdir();
		
		String file1, file2 ; 
		MultipartFile uploadfilef = vo.getUploadfilef();
		if ( uploadfilef !=null && !uploadfilef.isEmpty() ) {
		// ** new_Image 를 선택한 경우
			// 1) 물리적 저장경로에 new_Image 저장
			file1 = realPath + uploadfilef.getOriginalFilename(); // 경로완성
			uploadfilef.transferTo(new File(file1)); // Image저장
			
			// 2) Table 저장 준비
			file2="resources/uploadImage/"+uploadfilef.getOriginalFilename();
			vo.setUploadfile(file2);
		}
		// ** new_Image 를 선택하지 않은 경우 : form 에서 전송되어 vo에 담겨진 uploadfile 값을 사용하면 됨. 
		
		// 2. Service
		mv.addObject("apple", vo);
		
		if ( service.update(vo) > 0 ) {
			// 수정성공 -> MyInfo 내정보 표시 , session에 보관중인 LoginName 변경
			request.getSession().setAttribute("LoginName", vo.getName());
			mv.addObject("message", " ~~ 정보 수정 성공 ~~");
			mv.setViewName("member/memberDetail");
		}else {
			// 수정실패 -> updateForm 으로
			mv.addObject("message", " ~~ 정보 수정 실패 -> 다시하세요 ~~");
			mv.setViewName("member/updateForm");
		}
		// 3. 결과 : view 처리
		return mv;
	} //mupdate
	
	//** 8. Member Delete 
	@RequestMapping(value = "/mdelete")
	public ModelAndView mdelete(HttpServletRequest request, ModelAndView mv, MemberVO vo, RedirectAttributes rttr) {
		// 1. 요청분석 & Service
		HttpSession session = request.getSession(false); 
		if ( session!=null && session.getAttribute("LoginID")!=null ) {
			// 삭제가능
			vo.setId((String)session.getAttribute("LoginID"));
			if ( service.delete(vo) > 0 ) {
				// 삭제성공 -> session 무효화 -> home.jsp
				rttr.addFlashAttribute("message", " ~~ 회원탈퇴 성공, 1개월 후 재가입 가능 ~~");
				session.invalidate();
			}else {
				// 삭제실패 -> 서버오류 -> home.jsp
				rttr.addFlashAttribute("message", " ~~ 회원 탈퇴 처리중 서버 문제발생 , 잠시후 다시 하세요 ~~");
			}
		}else {
			// 삭제 불가능 -> 로그인 정보 없음 -> home.jsp
			rttr.addFlashAttribute("message", " ~~ 회원 탈퇴를 처리할수 없습니다 : 로그인 정보 없음 ~~");
		}
		
		// 2. 결과 : view 처리
		mv.setViewName("redirect:home");
		return mv;
	} //mdelete
	
} //class
