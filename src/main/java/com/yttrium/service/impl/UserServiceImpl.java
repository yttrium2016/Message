package com.yttrium.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yttrium.domain.Register;
import com.yttrium.domain.User;
import com.yttrium.mail.SendEMail;
import com.yttrium.mapper.RegisterMapper;
import com.yttrium.mapper.UserMapper;
import com.yttrium.service.UserService;
import com.yttrium.utils.MessageStringUtils;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Resource
	private RegisterMapper registerMapper;

	public User login(User user) {
		user.setPassword(MessageStringUtils.getMD5(user.getPassword()));
		User dbUser = userMapper.selectByLogin(user);
		if (dbUser != null) {
			return dbUser;
		}
		return null;
	}

	@Override
	public void sendMail(Register register) {
		String code = MessageStringUtils.getCode();
		register.setEmailCode(code);
		boolean isSend = SendEMail.mail(register.getEmailAddress(), MessageStringUtils.getSendStr(code));
		registerMapper.deleteByEmail(register.getEmailAddress());
		int i = registerMapper.insert(register);
		if (i > 0 && isSend) {
			System.out.println("保存成功");
		}
	}

	@Override
	public Register findRegistByCode(String code) {
		Register register = registerMapper.selectByCode(code);
		if (register != null) {
			return register;
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(MessageStringUtils.getMD5(user.getPassword()));
		int i = userMapper.insert(user);
		if (i>0) {
			registerMapper.deleteByEmail(user.getUserEmail());
			System.out.println("添加用户成功");
		}
	}

	@Override
	public User findUserByEmail(String emailAddress) {
		return userMapper.selectByEmail(emailAddress);
	}

}
