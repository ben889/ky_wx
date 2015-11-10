package com.framework.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String rolename;
	private String description;
	private String icon;
	private Integer createdbyuserid;
	private Date createdtime;

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(String rolename) {
		this.rolename = rolename;
	}

	/** full constructor */
	public Roles(String rolename, String description, String icon,
			Integer createdbyuserid, Timestamp createdtime) {
		this.rolename = rolename;
		this.description = description;
		this.icon = icon;
		this.createdbyuserid = createdbyuserid;
		this.createdtime = createdtime;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getCreatedbyuserid() {
		return this.createdbyuserid;
	}

	public void setCreatedbyuserid(Integer createdbyuserid) {
		this.createdbyuserid = createdbyuserid;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

}