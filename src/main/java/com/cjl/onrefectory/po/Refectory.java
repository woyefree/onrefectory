package com.cjl.onrefectory.po;

import java.util.Date;

public class Refectory {
	private Long id;
	private Admin admin;
	private String desc;
	private String tel;
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Refectory [id=" + id + ", admin=" + admin + ", desc=" + desc + ", tel=" + tel + ", createTime="
				+ createTime + "]";
	}
	
}
