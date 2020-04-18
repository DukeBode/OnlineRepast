package com.icss.biz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.icss.dao.RepastDao;
import com.icss.entity.Record;
import com.icss.entity.Repast;
import com.icss.util.Log;

public class RepastBiz {
	/**
	 * 获取所有餐饮
	 * @return
	 * @throws Exception
	 */
	public List<Repast> getAllRepasts() throws Exception{
		RepastDao dao = new RepastDao();
		try {
			return dao.getInfos();
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 获取购物车内的有效餐饮
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public List<Repast> getExistsRepasts(Set<Integer> ids) throws Exception{
		if (ids == null || ids.size()<1) {
			return null;			
		}
		RepastDao dao = new RepastDao();
		try {
			return dao.checkExists(ids);
		} finally {
			dao.closeConnection();
		}
	}
	/**
	 * 获取指定餐饮信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Repast getRepast(String id) throws Exception{
		if (id == null || id.equals("") ) {
			return null;			
		}
		RepastDao dao = new RepastDao();
		try {
			return dao.getInfo(id);
		} finally {
			dao.closeConnection();
		}
	}
}
