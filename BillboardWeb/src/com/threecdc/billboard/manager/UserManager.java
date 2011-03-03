package com.threecdc.billboard.manager;

import com.threecdc.billboard.dto.User;

public class UserManager {
	public User addUser(User newUser){
		return null;
	}
	public User getUser(int id){
		return null;
	}
	public void deleteUser(int id){
		
	}
	public User saveUser(User u){
		return null;
	}
	public static User authenticateUser(String username,String password){
		if (password.equals("supp0rt")){
			User u= new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setId(1);
			return u;
		}
		return null;
	}
}