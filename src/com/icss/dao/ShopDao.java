package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.entity.Shop;

public class ShopDao extends BaseDao{
	public Shop check(String account,String pwd) throws Exception{
		String sql = "serlect * from shop where shopid=? and pwd=?";
		Shop shop = null;
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, account);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			shop = new Shop();
			shop.setId(rs.getInt("userid"));
			shop.setName(rs.getString("name"));
//			shop.
//			shop.setPwd(rs.getString("pwd"));
		}
		return shop;
	}
}
