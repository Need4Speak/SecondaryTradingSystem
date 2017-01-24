/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.User;
import com.util.DBHelper;

/**
 * 
 * ProjectName：SecondaryTradingSystem ClassName：UserDAO ClassDescription：
 * Author：Pancake CreateTime：2017年1月23日 下午1:39:56
 * 
 * @version
 */
public class UserDAO {
	/**
	 * @return
	 */
	public static ArrayList<User> getAllUsers() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>(); // 用户集合

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				// User user = new User();
				// user.setUserId(rs.getInt("userId"));
				// user.setUserName(rs.getString("userName"));
				// user.setPassword(rs.getString("password"));
				// user.setPhoneNumber(rs.getInt("phoneNumber"));
				// user.setGender(rs.getString("gender"));
				// user.setUserPhoto(rs.getString("userPhoto"));
				// list.add(user);
				list.add(User.setAllProperties(rs));
			}
			return list;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}

			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is used to return a User class object by userId.
	 * 
	 * @param id
	 *            ： User id
	 * @return A class User object.
	 */
	public static User getUserById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where userId=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return User.setAllProperties(rs);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}

			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param userName: username.
	 * @return A User object.
	 */
	public static User getUserByName(String userName) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where userName=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return User.setAllProperties(rs);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
			}

			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method is used to identify weather the login info is true.
	 * @param userName: username
	 * @param password: password
	 * @return Weather the login info is true.
	 */
	public static boolean tryLogin(String userName, String password) {
		User user = getUserByName(userName);
		if (user != null) {
			String passwordInDB = user.getPassword();
			if (passwordInDB.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
