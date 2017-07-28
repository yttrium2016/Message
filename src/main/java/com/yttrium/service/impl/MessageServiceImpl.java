package com.yttrium.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.yttrium.domain.Message;
import com.yttrium.mapper.MessageMapper;
import com.yttrium.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageMapper messageMapper;

	@Override
	public void saveMessage(Message message) {
		message.setMessageTime(new Date());
		int i = messageMapper.insert(message);
		if (i > 0 ) {
			System.out.println("留言保存成功");
		}
	}

	@Override
	public List<Message> findAllMessage() {
		return messageMapper.selectAll();
	}

}
