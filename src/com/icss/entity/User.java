package com.icss.entity;

import java.util.Date;
/**
 * 用户
 * @author DukeBode
 *
 */
public class User {
	private String id;	   // 用户编号
	private String name;   // 用户名
	private String pwd;    // 密码
	private String mail;   // 邮箱
	private String phone;  // 手机号
	private String address;// 地址
	private Date date;     // 入驻时间
	private byte status;   // 状态 
	private int level;     // 等级
	private byte role;     // 权限
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public byte getRole() {
		return role;
	}
	public void setRole(byte role) {
		this.role = role;
	}
}
