package com.cjl.onrefectory.po;

import java.util.Date;

public class Admin {
	private Long id;
	private String name;
	private int gender;
	private String email;
	private String tel;
	private int role;
	private String pwd;
	private Date createTime;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", tel=" + tel
				+ ", role=" + role + ", pwd=" + pwd + ", createTime=" + createTime + "]";
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
