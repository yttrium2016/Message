package com.yttrium.service;

import com.yttrium.domain.Register;
import com.yttrium.domain.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 发送邮件 并且保存注册码到数据库
	 * @param register
	 */
	void sendMail(Register register);

	/**
	 * 查找已经发送的注册邮箱地址
	 * @param code
	 * @return
	 */
	Register findRegistByCode(String code);

	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 查找用户
	 * @param emailAddress
	 * @return
	 */
	User findUserByEmail(String emailAddress);
	
	

}
