package com.framework.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Users implements java.io.Serializable {

	// Fields

	private Integer userid = 0;
	private String username = "";
	private String password = "";
	private String displayname = "";
	private String email = "";
	private Integer status = 0;
	private String usertype = "";
	private Integer deleted = 0;
	private Integer locked = 0;
	private Integer createuserid = 0;
	private Date createtime;
	private String description = "";
	private Date lasttime;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public Users(String username, String password, String displayname,
			String email, Integer status, String usertype, Integer deleted,
			Integer locked, Integer createuserid, Timestamp createtime,
			String description, Timestamp lasttime) {
		this.username = username;
		this.password = password;
		this.displayname = displayname;
		this.email = email;
		this.status = status;
		this.usertype = usertype;
		this.deleted = deleted;
		this.locked = locked;
		this.createuserid = createuserid;
		this.createtime = createtime;
		this.description = description;
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", displayname=" + displayname
				+ ", email=" + email + ", status=" + status + ", usertype="
				+ usertype + ", deleted=" + deleted + ", locked=" + locked
				+ ", createuserid=" + createuserid + ", createtime="
				+ createtime + ", description=" + description + ", lasttime="
				+ lasttime + "]";
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayname() {
		return this.displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Integer getLocked() {
		return this.locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	public Integer getCreateuserid() {
		return this.createuserid;
	}

	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

}