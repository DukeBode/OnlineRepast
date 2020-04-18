package com.icss.entity;

import java.util.Date;
/**
 * 订单
 * @author DukeBode
 *
 */
public class Order {
	private String id;         // 订单编号
	private String userid;     // 用户编号
	private String deliveryid; // 配送信息
	private Date buytime;      // 下单时间
	private String address;    // 地址
	private String contact;    // 联系方式
	private Date time;         // 预定时间
	private int number;        // 订餐数量
	private double allpay;     // 消费金额
	private byte paytype;      // 付款方式
	private String paycode;    // 付款编号
	private String other;      // 备注
	private byte status;       // 状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDeliveryid() {
		return deliveryid;
	}
	public void setDeliveryid(String deliveryid) {
		this.deliveryid = deliveryid;
	}
	public Date getBuytime() {
		return buytime;
	}
	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getAllpay() {
		return allpay;
	}
	public void setAllpay(double allpay) {
		this.allpay = allpay;
	}
	public byte getPaytype() {
		return paytype;
	}
	public void setPaytype(byte paytype) {
		this.paytype = paytype;
	}
	public String getPaycode() {
		return paycode;
	}
	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}

}
