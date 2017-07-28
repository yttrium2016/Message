package com.yttrium.mail;


public class SendEMail {
	
	private static MailSenderInfo mailInfo = null;
	
	
	static{
		// 这个类主要是设置邮件
		mailInfo = new MailSenderInfo();

		mailInfo.setMailServerHost("smtp.mxhichina.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);

		mailInfo.setUserName("Administrator@yzyihqm.cn");  //你的邮箱帐号

		mailInfo.setPassword("****");// 您的邮箱密码

		mailInfo.setFromAddress("Administrator@yzyihqm.cn"); //发送邮件的邮箱
		
		mailInfo.setSubject("谢谢你的注册~");//邮件标题
		
	}
	
	/**
	 * 发送邮件的类
	 * @param mail
	 * @param Code
	 * @return
	 */
	public static boolean mail(String mail,String Code) {
		
		mailInfo.setToAddress(mail);
		mailInfo.setContent(Code);
		// 这个类主要来发送邮件
		MyMailSender sms = new MyMailSender();
		return sms.sendTextMail(mailInfo);// 发送文体格式
		// sms.sendHtmlMail(mailInfo);//发送html格式
	}
}
