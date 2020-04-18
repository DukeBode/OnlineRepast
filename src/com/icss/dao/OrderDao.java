package com.icss.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import com.icss.entity.Order;
import com.icss.util.Log;

public class OrderDao extends BaseDao {
	/**
	 * 获取历史订单
	 * @param id 用户id
	 * @return 
	 * @throws Exception
	 */
	public Set<String> getsId(String id) throws Exception {
		String sql="select orderid from torder where userid=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Set<String> strings = new HashSet<>();
		while (rs.next()) {
			strings.add(rs.getString("orderid"));
		}
		return strings;
	}
	/**
	 * 创建订单
	 * @param id 用户id
	 * @return 订单
	 * @throws Exception
	 */
	public void create(Order order) throws Exception {
		String sql = "insert into torder values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, order.getId());
		ps.setString(2, order.getUserid());
		ps.setString(3, order.getDeliveryid());
		ps.setDate(4, new Date(order.getBuytime().getTime()));
		ps.setString(5, order.getAddress());
		ps.setString(6, order.getContact());
		ps.setDate(7, null);
		ps.setInt(8, order.getNumber());
		ps.setDouble(9, order.getAllpay());
		ps.setByte(10, order.getPaytype());
		ps.setString(11, order.getPaycode());
		ps.setString(12, order.getOther());
		ps.setByte(13, order.getStatus());
		ps.executeUpdate();
		ps.close();
		Log.logger.info("生成订单");
	}
	
}
