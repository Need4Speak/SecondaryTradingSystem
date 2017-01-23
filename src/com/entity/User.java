/**
 * 
 */
package com.entity;

/**
 * This file is used as User model, entity user has userId, userName, password,
 * phoneNumber, gender. ProjectName：SecondaryTradingSystem ClassName：User
 * ClassDescription： Author：Pancake CreateTime：2017年1月23日 下午1:33:20
 * 
 * @version
 */
public class User {
	private int userId;
	private String userName;
	private String password;
	private int phoneNumber;
	private String gender;
	private String userPhoto;

	public User() {
		super();
	}

	public User(int userId, String userName, String password, int phoneNumber,
			String gender, String userPhoto) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "userId: " + this.userId + ", userName: " + this.userName
				+ ", phoneNumber: " + this.phoneNumber + ", gender: "
				+ this.gender + ", userPhoto: " + this.userPhoto;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
