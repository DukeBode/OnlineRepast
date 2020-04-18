package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import com.icss.entity.Record;
import com.icss.util.Log;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

public class RecordDao extends BaseDao {
	// TODO 实现
	/**
	 * 将购物车中选择的记录设置订单号
	 * @param id 订单号
	 * @param repasts 餐饮及数量
	 * @throws Exception
	 */
	public void setOrder(String id, Map<Integer,Integer> repasts) throws Exception {
		// TODO 有误不实现
	}
	/**
	 * 设置订单号
	 * @param oldId 购物车id
	 * @param newId 订单id
	 * @throws Exception
	 */
	public void setPay(String id,List<Record> records) throws Exception {
		String sql = "update trecord set orderid=if(number>?,orderid,?),number=if(number>?,number-?,?),piece=? where repastid=? and orderid=?;";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		for (Record record : records) {
			ps.setInt(1, record.getNumber());
			ps.setString(2, record.getOrderid());
			ps.setInt(3, record.getNumber());
			ps.setInt(4, record.getNumber());
			ps.setInt(5, record.getNumber());
			ps.setDouble(6, record.getPiece());
			ps.setInt(7, record.getRepastid());
			ps.setString(8, id);
			ps.executeUpdate();
		}
		ps.close();
		String sql2 = "insert into trecord(repastid,orderid,number,piece) value (?,?,?,?) on duplicate key update number=number;";
		PreparedStatement ps2 = this.conn.prepareStatement(sql2);
		for (Record record : records) {
			ps2.setInt(1, record.getRepastid());
			ps2.setString(2, record.getOrderid());
			ps2.setInt(3, record.getNumber());
			ps2.setDouble(4,record.getPiece());
			ps2.executeUpdate();
		}
		ps2.close();
		Log.logger.info("设置订单号");
	}
	/**
	 * 获取指定订单号的购物记录
	 * @param id 订单号
	 * @return 记录
	 * @throws Exception
	 */
	public List<Record> gets(String id) throws Exception {
		String sql = "select * from trecord where orderid=? and number>0";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		List<Record> records = new ArrayList<>();
		while (rs.next()) {
			Record record = new Record();
			record.setRepastid(rs.getInt("repastid"));
			record.setOrderid(rs.getString("orderid"));
			record.setNumber(rs.getInt("number"));
			record.setPiece(rs.getDouble("piece"));
			records.add(record);
		}
		rs.close();
		ps.close();
		return records;
	}
	/**
	 * 设置价格
	 * @param record
	 * @throws Exception
	 */
	public void setPiece(Record record) throws Exception {
		if (record.getNumber()>=0) {
			String sql="update trecord set piece=? where repastid=? and orderid=?";
			this.openConnection();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setDouble(1,record.getPiece());
			ps.setInt(2, record.getRepastid());
			ps.setString(3, record.getOrderid());
			ps.executeUpdate();
			ps.close();
		}
	}
	/**
	 * 设置数量
	 * @param record
	 * @throws Exception
	 */
	public void setNumber(Record record) throws Exception {
		if (record.getNumber()>=0) {
			String sql="update trecord set number=? where repastid=? and orderid=?";
			this.openConnection();
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, record.getNumber());
			ps.setInt(2, record.getRepastid());
			ps.setString(3, record.getOrderid());
			ps.executeUpdate();
			ps.close();
			Log.logger.info("设置购物记录");
		}
	}
	/**
	 * 更新数量，若不存在则创建，数量为零则删除
	 * @param record number为正表示增加
	 * @throws Exception
	 */
	public void update(Record record) throws Exception {
		String sql="insert into trecord(repastid,orderid,number,piece) value (?,?,?,?) on duplicate key update repastid=?,orderid=?,number=number+?,piece=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		try {			
			ps.setInt(1, record.getRepastid());
			ps.setString(2, record.getOrderid());
			if (record.getNumber()>0) {
				ps.setInt(3, record.getNumber());
			} else {			
				ps.setInt(3, 0);
			}
			ps.setDouble(4,record.getPiece());
			ps.setInt(5, record.getRepastid());
			ps.setString(6, record.getOrderid());
			ps.setInt(7, record.getNumber());
			ps.setDouble(8,record.getPiece());
			ps.executeUpdate();
			Log.logger.info("更新购物车");
		} catch (MysqlDataTruncation e){
			Log.logger.info("数量为负",e);
		} catch (Exception e){
			Log.logger.error("记录更新异常",e);
		}finally{
			ps.close();
		}
	}
	/**
	 * 
	 * @param ids 订单 id 的集合
	 * @return 记录
	 * @throws Exception
	 */
	public List<Record> getsPay(Set<String> ids) throws Exception {
		StringJoiner liststr = new StringJoiner("\",\"", "(\"", "\")");
		for (String rid : ids) {
			liststr.add(rid);
		}
		String sql = "select * from trecord where number>0 and orderid in "+liststr;
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Record> records = new ArrayList<>();
		while (rs.next()) {
			Record record = new Record();
			record.setRepastid(rs.getInt("repastid"));
			record.setOrderid(rs.getString("orderid"));
			record.setNumber(rs.getInt("number"));
			record.setPiece(rs.getDouble("piece"));
			records.add(record);
		}
		rs.close();
		ps.close();
		return records;
	}
}
