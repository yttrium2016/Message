package com.yttrium.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.druid.util.StringUtils;

import com.yttrium.domain.Message;
import com.yttrium.service.MessageService;

@Controller
public class MessageContrller {
	@Resource
	MessageService messageService;
	
	@RequestMapping(value="addMessage",method=RequestMethod.POST)
	public String addMessage(Message message,Model model){
		if (StringUtils.isEmpty(message.getMessageTitle())) {
			model.addAttribute("error", "标题不能为空");
			return "error";
		}
		if (StringUtils.isEmpty(message.getMessageContent())) {
			model.addAttribute("error", "内容不能为空");
			return "error";
		}
		messageService.saveMessage(message);
		return "redirect:home.html";
	}
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(HttpServletRequest request,Model model){
		Object obj = request.getSession().getAttribute("loginUser");
		if (obj == null) {
			return "redirect:login.html";
		}
		List<Message> messageList = messageService.findAllMessage();
		model.addAttribute("messageList",messageList);
		return "home";
	}
}
