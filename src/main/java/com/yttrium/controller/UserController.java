package com.yttrium.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.util.StringUtils;
import com.yttrium.domain.Register;
import com.yttrium.domain.User;
import com.yttrium.service.UserService;

@Controller
public class UserController {
	
	@Resource
	UserService userService;
	
	@RequestMapping(value="doLogin",method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request,User user,Model model){
		User dbUser = userService.login(user);
		if (dbUser != null) {
			request.getSession().setAttribute("loginUser", dbUser);
			return "redirect:home.html";
		}
		model.addAttribute("error", "登录失败");
		return "error";
	}
	
	
	@RequestMapping(value="sendMail",method=RequestMethod.POST)
	public String sendMail(String code,Register register,HttpServletRequest request,Model model) {
		//获取session中的验证码(全大写)
		String sessionCode = (String)request.getSession().getAttribute("code");
		if (StringUtils.isEmpty(code)) {
			model.addAttribute("error", "验证码不能为空");
			return "error";
		}else {
			//忽略大小写的对比
			if (!sessionCode.equalsIgnoreCase(code)) {
				model.addAttribute("error", "验证码错误");
				return "error";
			}
		}
		User dbUser = userService.findUserByEmail(register.getEmailAddress());
		if (dbUser != null) {
			model.addAttribute("error", "已经存在该邮箱");
			return "error";
		}
		
		if (register.getEmailAddress()!=null) {
			userService.sendMail(register);
		}
		model.addAttribute("success","发送邮件成功");
		model.addAttribute("doc","请登录邮箱继续注册.<br>2秒后自动跳转到登录界面");
		return "success";
	}
	
	@RequestMapping(value="exit",method=RequestMethod.GET)
	public String exit(HttpServletRequest request,User user,Model model){
		request.getSession().removeAttribute("loginUser");	
		return "redirect:login.html";
	}
	
	@RequestMapping(value="goRegist",method=RequestMethod.GET)
	public String goRegist(String code,Model model){
		if (code != null) {
			Register register = userService.findRegistByCode(code);
			if (register != null) {
				model.addAttribute("address", register.getEmailAddress());
				return "user";
			}
		}
		model.addAttribute("error","注册码已经失效,请重新发送注册嘛");
		return "error";
	}
	
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	public String saveUser(User user,Model model){
		if (StringUtils.isEmpty(user.getUserName())) {
			model.addAttribute("error","用户名不能为空");
			return "error";
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			model.addAttribute("error","密码不能为空");
			return "error";
		}
		if (StringUtils.isEmpty(user.getRepassword())) {
			model.addAttribute("error","确认密码不能为空");
			return "error";
		}
		if (!user.getPassword().equals(user.getRepassword())) {
			model.addAttribute("error","两次密码输入的不一致");
			return "error";
		}
		userService.saveUser(user);
		model.addAttribute("success","注册成功");
		model.addAttribute("doc","2秒后自动跳转到登录界面");
		return "success";
	}
	
}
