package com.yttrium.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yttrium.utils.YCoptchaCode;

/**
 * 控制页面的显示
 * @author 杨振宇
 *
 */
@Controller
public class ViewController {
	
	@RequestMapping(value="{str}",method=RequestMethod.GET)
	public String viewResult(@PathVariable String str) {
		String[] strings  = {"login","success","regist"};
		for (String string : strings) {
			if (string.equals(str)) {
				return str;
			}
		}
		return "error";
	}

	@RequestMapping(value="coptcha",method=RequestMethod.GET)
	public String Coptcha(HttpServletRequest request,HttpServletResponse response) throws IOException {
		/*
		 * 使用第三方生成验证码的jar包
		 * 	 1.拷贝ValidateCode.jar到工程lib目录
		 * 	 2.创建ValidateCode的对象
		 * 	 3.获取响应对象输出流
		 * 	 4.输出到浏览器
		 */
		//创建ValidateCode的对象
		//参数详解：1:图像宽度 2.图像高度 3.数字的格式 4.干扰线条数
		YCoptchaCode code = new YCoptchaCode(90,30,4,10);
		HttpSession session = request.getSession();
		session.setAttribute("code", code.getCode());
		code.write(response.getOutputStream());
		return null;
	}
}
