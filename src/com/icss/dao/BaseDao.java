package com.icss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.icss.util.Log;
/**
 * 封装数据库操作
 * @author DukeBode
 *
 */
public abstract class BaseDao {
	protected Connection conn;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	/**
	 * 打开数据库连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void openConnection() throws ClassNotFoundException,SQLException{
		try {
			if (this.conn==null||this.conn.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/online?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&tinyInt1isBit=false&zeroDateTimeBehavior=convertToNull";
				String username = "root";
				String password = "";
				conn = DriverManager.getConnection(url, username, password);
				Log.logger.info("建立数据库连接");
			} else {				
				Log.logger.info("重用数据库连接");
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	/**
	 * 开启事务
	 * @throws Exception
	 */
	public void beginTransaction() throws Exception{
		this.openConnection();
		this.conn.setAutoCommit(false);
		Log.logger.info("开启事务");
	}
	/**
	 * 提交事务
	 * @throws Exception
	 */
	public void commit() throws Exception{
		if (this.conn != null) {
			this.conn.commit();
			Log.logger.info("提交事务");
		}
	}
	/**
	 * 回滚事务
	 * @throws Exception
	 */
	public void rollback() throws Exception{
		if (this.conn != null) {
			this.conn.rollback();
		}
	}
	/**
	 * 关闭数据库连接
	 * @throws Exception
	 */
	public void closeConnection() throws Exception{
		if (this.conn != null) {
			try {
				this.conn.close();
				Log.logger.info("关闭数据库连接");
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
