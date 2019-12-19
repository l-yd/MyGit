package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Service.UserService;
import com.pojo.User;

@Controller
@RequestMapping("user")
@SessionAttributes("loginuser")
public class UserController {
	@Resource
	private UserService us;
	
	@RequestMapping("login")
	public ModelAndView login(User user,ModelAndView mav) {
//		List<User> loginusers = null;
//		loginusers.add(us.userlogin(user));
		User loginuser=us.userlogin(user);
		if(loginuser==null) {
			mav.setViewName("../login");
		}else {
			mav.addObject("loginuser",loginuser);
			mav.setViewName("../main");
		}
		return mav;
	}

}
