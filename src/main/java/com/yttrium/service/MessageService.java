package com.yttrium.service;


import java.util.List;

import com.yttrium.domain.Message;

public interface MessageService {

	/**
	 * 保存留言
	 * @param message
	 */
	void saveMessage(Message message);

	/**
	 * 查询所有留言
	 * @return
	 */
	List<Message> findAllMessage();

}
