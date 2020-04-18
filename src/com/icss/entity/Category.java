package com.icss.entity;
/**
 * 店铺餐饮分类
 * @author DukeBode
 *
 */
public class Category {
	private int id;      // 分类编号
	private int shopid;  // 店铺
	private String type; // 类别名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
