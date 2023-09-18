package org.sp.springapp.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sp.springapp.domain.Admin;
import org.sp.springapp.exception.AdminException;
import org.sp.springapp.model.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	//로그인 폼 요청 처리
	@GetMapping("/admin/loginform")
	public ModelAndView loginfrom() {
		ModelAndView mav = new ModelAndView("admin/loginform");
		return mav;
	}
	@GetMapping("/admin/regist")
	public ModelAndView regist() {
		ModelAndView mav = new ModelAndView("admin/joinform");
		return mav;
	}
	//로그인 요청 처리
	@PostMapping("/admin/login")
	public ModelAndView login(Admin admin, HttpServletRequest request) {
		System.out.println("====>로그인 시도");
		//3단계 : 일치하는 관리자가 있는지 조회
		Admin dto=adminService.login(admin);
		System.out.println("====>로그인 일치함");
		
		//4단계: 일치하는 관리자가 있다면, 세션에 DTO를 담아서 서비스해준다.
		HttpSession session=request.getSession();
		System.out.println("====>세션 담음");
		session.setAttribute("admin", dto);
		System.out.println("====>admin 보여주기");
		
		ModelAndView mav = new ModelAndView("gallery/index");
		return mav;
	}

	
	@ExceptionHandler(AdminException.class)
	public ModelAndView handle(AdminException e) {
		ModelAndView mav = new ModelAndView("error/result");
		mav.addObject("e",e);
		return mav;
	}
}
