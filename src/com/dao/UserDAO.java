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
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setGender(rs.getString("gender"));
				user.setUserPhoto(rs.getString("userPhoto"));
				list.add(user);
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
}
