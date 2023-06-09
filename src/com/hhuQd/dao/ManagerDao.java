package com.hhuQd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hhuQd.util.DBManager;

public class ManagerDao {
	private DBManager db = new DBManager();

	/**
	 * 检查手机号码是否存在
	 * 
	 * @param phoneNo
	 * @return
	 */
	public boolean existPhone(String phoneNo) {

		try {
			// String * from account where sphone='1111111'

			String sql = "select * from manager where mphone='" + phoneNo
					+ "' ";

			ResultSet rs = db.query(sql);

			return rs.next();// next的含义是 是否存在数据，如果存在在返回true，否则返回false
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * 通过手机号码获取密码
	 * 
	 * @param phoneNo
	 * @return
	 */
	public String getPassByPhoneNo(String phoneNo) {
		String pass = null;
		try {

			String sql = "select * from manager where mphone='" + phoneNo
					+ "' ";

			ResultSet rs = db.query(sql);
			if (rs.next()) {
				pass = rs.getString("mpass");
				//System.out.println("=============================>"+pass);
			}
			db.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pass;

	}

	/**
	 * 修改密码
	 * 
	 * @param phoneNo
	 * @param pass
	 */

	public void repass(String phoneNo, String pass) {
		String sql = "update manager set mpass ='" + pass + "' where mphone='"
				+ phoneNo + "'";

		db.update(sql);
	}

	 
}
