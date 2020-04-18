package com.icss.entity;
/**
 * 订单记录
 * @author DukeBode
 *
 */
public class Record {
	private int repastid;  // 餐饮编号
	private String orderid;// 订单编号
	private int number;    // 数量
	private double piece;  // 交易价格
	public int getRepastid() {
		return repastid;
	}
	public void setRepastid(int repastid) {
		this.repastid = repastid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPiece() {
		return piece;
	}
	public void setPiece(double piece) {
		this.piece = piece;
	}
}
