package com.icss.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.entity.User;
import com.icss.util.Log;

public class UserDao extends BaseDao{
	/**
	 * 查询用户信息
	 * @param account 用户账户
	 * @param pwd 用户密码
	 * @return 用户对象
	 * @throws Exception 异常
	 */
	public User get(String id,String pwd) throws Exception{
		String sql = "select * from tuser where userid=? and pwd=?";
		User user = null;
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			user = new User();
			user.setId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("pwd"));
			user.setMail(rs.getString("mail"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setDate(rs.getDate("date"));
			user.setStatus(rs.getByte("status"));
			user.setLevel(rs.getInt("level"));
			user.setRole(rs.getByte("role"));
			break;
		}
		rs.close();
		ps.close();
		return user;
	}
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void add(User user) throws Exception{
		String sql = "insert into tuser values(?,?,?,?,?,?,?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPwd());
		ps.setString(4, user.getMail());
		ps.setString(5, user.getPhone());
		ps.setString(6, user.getAddress());
		ps.setDate(7, new Date(user.getDate().getTime()));
		ps.setByte(8, user.getStatus());
		ps.setInt(9, user.getLevel());
		ps.setByte(10, user.getRole());
		ps.executeUpdate();
		ps.close();
		Log.logger.info("添加用户");
	}
	/**
	 * 更新用户金额
	 * @param id 用户
	 * @param money 增加的金额
	 * @throws Exception
	 */
	public void updateMoney(String id, double money) throws Exception{
		String sql="update tuser set status=status+? where userid=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setByte(1, (byte)money);
		ps.setString(2, id);
		ps.executeUpdate();
		ps.close();
		Log.logger.info("扣费");
	}
	/**
	 * 检查用户名是否存在
	 * @param account 用户名
	 * @return true 存在
	 * @throws Exception
	 */
	public boolean checkExist(String id) throws Exception {
		String sql = "select userid from tuser where userid=?";
		this.openConnection();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			rs.close();
			ps.close();
			return true;
		}
		return false;
	}
}
