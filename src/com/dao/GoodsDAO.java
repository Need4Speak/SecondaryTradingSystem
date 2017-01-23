/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Goods;
import com.util.DBHelper;

/**
 * DAO layer for goods' process. ProjectName：SecondaryTradingSystem
 * ClassName：GoodsDAO ClassDescription： Author：Pancake CreateTime：2017年1月23日
 * 上午5:59:52
 * 
 * @version
 */
public class GoodsDAO {

	public static ArrayList<Goods> getAllGoods() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>(); // 商品集合

		try {
			conn = DBHelper.getConnection();
			String sql = "select * from goods;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Goods good = new Goods();
				good.setGoodId(rs.getInt("id"));
				good.setGoodName(rs.getString("name"));
				good.setGoodPrice(rs.getInt("price"));
				good.setGoodPictures(rs.getString("pictures"));
				list.add(good);
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
