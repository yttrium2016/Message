package com.yttrium.domain;


public class User {
    private Integer userId;

    private String userName;

    private String userEmail;

    private String password;
    
    private String repassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public String getRepassword() {
		return repassword;
	}
    
    public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}