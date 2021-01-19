package com.udemy.model;

public class UserCredential 
{

	private String username;
	private String userpasssword;
	
	public UserCredential () {}
	
	
	
	public UserCredential(String username, String userpasssword) {
		super();
		this.username = username;
		this.userpasssword = userpasssword;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpasssword() {
		return userpasssword;
	}
	public void setUserpasssword(String userpasssword) {
		this.userpasssword = userpasssword;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserCredential [username=");
		builder.append(username);
		builder.append(", userpasssword=");
		builder.append(userpasssword);
		builder.append("]");
		return builder.toString();
	}
	
 
}
