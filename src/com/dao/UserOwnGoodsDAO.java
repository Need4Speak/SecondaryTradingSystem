/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;
import com.entity.UserOwnGoods;
import com.util.DBHelper;

/**
 * Use to get userId by goodsId or get goodsId by userId.
 * ProjectName：SecondaryTradingSystem ClassName：UserOwnGoodsDAO
 * ClassDescription： Author：Pancake CreateTime：2017年1月23日 下午4:24:37
 * 
 * @version
 */
public class UserOwnGoodsDAO {
	/**
	 * @param goodsId
	 * @return
	 */
	public static int getUserIdByGoodsId(int goodsId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from userOwnGoods where goodsId=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, goodsId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return UserOwnGoods.setAllProperties(rs).getUserId();
			} else {
				return -1;
			}
		} catch (Exception e) {
			return -1;
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

	public static int getGoodsIdByUserId(int userId) {
		return 0;
	}
}
