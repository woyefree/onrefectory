package com.cjl.onrefectory.po;

import java.util.Date;

public class Food {
	private Long id;
	private Refectory refectory;
	private String name;
	private String type;
	private String image;   //图片上传的地址
	private String descc;
	private int status;
	private double price;
	private double vipPrice;
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDesc() {
		return descc;
	}
	public void setDesc(String descc) {
		this.descc = descc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(double vipPrice) {
		this.vipPrice = vipPrice;
	}
	public Refectory getRefectory() {
		return refectory;
	}
	public void setRefectory(Refectory refectory) {
		this.refectory = refectory;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", refectory=" + refectory + ", name=" + name + ", type=" + type + ", image=" + image
				+ ", descc=" + descc + ", status=" + status + ", price=" + price + ", vipPrice=" + vipPrice
				+ ", createTime=" + createTime + "]";
	}
	
	
}
