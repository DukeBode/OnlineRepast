package com.icss.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import com.icss.entity.Repast;
import com.icss.util.Log;

public class RepastDao extends BaseDao{
	/**
	 * 餐饮信息添加
	 * @param repast
	 * @throws Exception
	 */
	public void add(Repast repast) throws Exception {
		// TODO SQL 配置
		String sql = "";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setInt(1, repast.getId());
		ps.setString(2, repast.getName());
		ps.setString(3, repast.getPic());
		ps.setInt(4, repast.getShopid());
		ps.setInt(5, repast.getCategoryid());
		ps.setDouble(6, repast.getPrice());
		ps.setString(7, repast.getUnit());
		ps.setDate(8, new Date(repast.getTime().getTime()));
		ps.setInt(9, repast.getStatus());
		ps.executeUpdate();
	}
	/**
	 * 餐饮信息查询
	 * @param repastid id值
	 * @return Repast对象
	 * @throws Exception
	 */
	public Repast getInfo(String id) throws Exception {
		String sql = "select * from trepast where repastid=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Repast repast = null;
		while (rs.next()) {
			repast = new Repast();
			repast.setId(rs.getInt("repastid"));
			repast.setName(rs.getString("name"));
			repast.setPic(rs.getString("pic"));
			repast.setShopid(rs.getInt("shopid"));
			repast.setCategoryid(rs.getInt("categoryid"));
			repast.setPrice(rs.getDouble("price"));
			repast.setUnit(rs.getString("unit"));
			repast.setTime(rs.getDate("time"));
			repast.setStatus(rs.getByte("status"));
		}
		return repast;
	}
	/**
	 * 查询存在的餐饮信息
	 * @param rids 给定的餐饮集合
	 * @return 有效的Repast对象列表
	 * @throws Exception
	 */
	public List<Repast> checkExists(Set<Integer> ids) throws Exception {
		StringJoiner liststr = new StringJoiner(",", "(", ")");
		for (int rid : ids) {
			liststr.add(String.valueOf(rid));
		}
		String sql = "select * from trepast where repastid in "+liststr;
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Repast> repasts = new ArrayList<>();
		while (rs.next()) {
			Repast repast = new Repast();
			repast.setId(rs.getInt("repastid"));
			repast.setName(rs.getString("name"));
			repast.setPic(rs.getString("pic"));
			repast.setShopid(rs.getInt("shopid"));
			repast.setCategoryid(rs.getInt("categoryid"));
			repast.setPrice(rs.getDouble("price"));
			repast.setUnit(rs.getString("unit"));
			repast.setTime(rs.getDate("time"));
			repast.setStatus(rs.getByte("status"));
			repasts.add(repast);
		}
		rs.close();
		ps.close();
		Log.logger.info("获取餐饮id集合中有效的餐饮信息");
		return repasts;
	}
	/**
	 * 获取餐饮列表及信息
	 * @return
	 * @throws Exception
	 */
	public List<Repast> getInfos() throws Exception {
		String sql = "select * from trepast";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Repast> repasts = new ArrayList<>();
		while (rs.next()) {
			Repast repast = new Repast();
			repast.setId(rs.getInt("repastid"));
			repast.setName(rs.getString("name"));
			repast.setPic(rs.getString("pic"));
			repast.setShopid(rs.getInt("shopid"));
			repast.setInfo(rs.getString("info"));
			repast.setCategoryid(rs.getInt("categoryid"));
			repast.setPrice(rs.getDouble("price"));
			repast.setUnit(rs.getString("unit"));
			repast.setTime(rs.getDate("time"));
			repast.setStatus(rs.getByte("status"));
			repasts.add(repast);
		}
		rs.close();
		ps.close();
		Log.logger.info("获取所有餐饮");
		return repasts;
	}
}
