package com.icss.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.dao.OrderDao;
import com.icss.dao.RecordDao;
import com.icss.dao.UserDao;
import com.icss.entity.Order;
import com.icss.entity.Record;
import com.icss.entity.Repast;
import com.icss.entity.User;
import com.icss.util.Log;
import com.icss.util.OrderUtil;

public class UserBiz {
	/**
	 * 
	 * @param userid
	 * @param repastid
	 * @param num
	 * @param set
	 * @throws Exception
	 */
	public void setCartRecord(String userid,int repastid,int num,boolean set) throws Exception {
		RecordDao dao = new RecordDao();
		try {
			Record record = new Record();
			record.setOrderid("tmp"+userid);
			record.setRepastid(repastid);
			record.setNumber(num);
			dao.setNumber(record);
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 设置购物车中的餐饮数量
	 * @param id 餐饮id
	 * @param num 数量
	 * @throws Exception
	 */
	public void setCartRecord(String userid,int repastid,int num) throws Exception {
		RecordDao dao = new RecordDao();
		try {
			Record record = new Record();
			record.setOrderid("tmp"+userid);
			record.setRepastid(repastid);
			record.setNumber(num);
			dao.update(record);
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 获取购物历史
	 * @param id 用户id
	 * @return 历史购物记录
	 * @throws Exception
	 */
	public List<Record> getBuyHistory(String id) throws Exception {
		RecordDao dao = new RecordDao();
		try {
			return dao.getsPay(new OrderDao().getsId(id));
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 获取用户的购物车
	 * @param id 用户的id
	 * @return 购物车餐饮记录
	 * @throws Exception
	 */
	public Map<Integer,Integer> getCart(String id) throws Exception {
		if (id == null || id.equals("")) {
			return null;
		}
		RecordDao dao = new RecordDao();
		try {
			List<Record> records = dao.gets("tmp"+id);
			Map<Integer,Integer> dict=new HashMap<>();
			for (Record record : records) {
				dict.put(record.getRepastid(), record.getNumber());
			}
			return dict;
		} finally {
			dao.closeConnection();
		}
		
	}
	/**
	 * 用户登录
	 * @param id 用户名
	 * @param pwd 密码
	 * @return 用户对象
	 * @throws Exception
	 */
	public User login(String id, String pwd) throws Exception {
		if(id == null || id.equals("") || pwd == null || pwd.equals("")) {
			return null;
		}
		UserDao dao = new UserDao();
		try {
			return dao.get(id, pwd);
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 付款，修改订单记录
	 * @param user
	 * @param allMoney
	 * @param repasts
	 * @throws Exception
	 */
	public void payMoney(User user, double allPay, List<Record> records) throws Exception{
		UserDao userDao = new UserDao();
		try {
			userDao.beginTransaction();
			userDao.updateMoney(user.getId(), -allPay);
			OrderDao orderDao = new OrderDao();
			orderDao.setConn(userDao.getConn());
			Order order = new Order();
			order.setId(OrderUtil.createNewOrderNo());
			order.setUserid(user.getId());
			order.setBuytime(new Date());
			order.setAddress(user.getAddress());
			order.setContact(user.getPhone());
			order.setAllpay(allPay);
			orderDao.create(order);
			for (Record record : records) {
				record.setOrderid(order.getId());
			}
			RecordDao recordDao = new RecordDao();
			recordDao.setConn(userDao.getConn());
			recordDao.setPay("tmp"+user.getId(), records);
			userDao.commit();
			Log.logger.info("交易成功");
		} catch (Exception e){
			userDao.rollback();
			Log.logger.error("交易错误",e);
		}finally {
			userDao.closeConnection();
		}
	}
	/**
	 * 用户注册
	 * @param user 用户对象
	 * @throws Exception
	 */
	public void regist(User user) throws Exception {
		if (user == null || user.getId() == null || user.getId().equals("")) {
			
		}
		UserDao dao = new UserDao();
		try {
			dao.add(user);
			Log.logger.info("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.closeConnection();
		}
	}
	/**
	 * 判断用户名是否存在
	 * @param account 用户名
	 * @return
	 * @throws Exception
	 */
	public boolean isUser(String id) throws Exception {
		if (id == null || id.equals("")) {
			return false;
		}
		UserDao dao = new UserDao();
		try {
			return dao.checkExist(id);
		} finally {
			dao.closeConnection();
		}
	}
}
