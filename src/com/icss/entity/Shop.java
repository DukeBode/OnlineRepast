package com.icss.entity;

import java.util.Date;
/**
 * 商铺
 * @author DukeBode
 *
 */
public class Shop {
	private int id;        // 商户编号
	private String userid; // 店管理员
	private String name;   // 店名
	private String keeper; // 店主
	private String phone;  // 联系电话
	private String address;// 地理位置
	private Date date;     // 入驻日期
	private byte status;   // 状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeeper() {
		return keeper;
	}
	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
}
