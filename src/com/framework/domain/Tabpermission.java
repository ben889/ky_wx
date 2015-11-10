package com.framework.domain;

import java.sql.Timestamp;

/**
 * Tabpermission entity. @author MyEclipse Persistence Tools
 */

public class Tabpermission implements java.io.Serializable {

	// Fields

	private Integer tabpermissionid;
	private Integer tabid;
	private Integer permissionid;
	private Boolean allowAccess;
	private Integer roleid;
	private Integer userid;
	private Integer createdbyuserid;
	private Timestamp createdtime;

	// Constructors

	/** default constructor */
	public Tabpermission() {
	}

	/** minimal constructor */
	public Tabpermission(Integer permissionid, Boolean allowAccess) {
		this.permissionid = permissionid;
		this.allowAccess = allowAccess;
	}

	/** full constructor */
	public Tabpermission(Integer tabid, Integer permissionid,
			Boolean allowAccess, Integer roleid, Integer userid,
			Integer createdbyuserid, Timestamp createdtime) {
		this.tabid = tabid;
		this.permissionid = permissionid;
		this.allowAccess = allowAccess;
		this.roleid = roleid;
		this.userid = userid;
		this.createdbyuserid = createdbyuserid;
		this.createdtime = createdtime;
	}

	// Property accessors

	public Integer getTabpermissionid() {
		return this.tabpermissionid;
	}

	public void setTabpermissionid(Integer tabpermissionid) {
		this.tabpermissionid = tabpermissionid;
	}

	public Integer getTabid() {
		return this.tabid;
	}

	public void setTabid(Integer tabid) {
		this.tabid = tabid;
	}

	public Integer getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}

	public Boolean getAllowAccess() {
		return this.allowAccess;
	}

	public void setAllowAccess(Boolean allowAccess) {
		this.allowAccess = allowAccess;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCreatedbyuserid() {
		return this.createdbyuserid;
	}

	public void setCreatedbyuserid(Integer createdbyuserid) {
		this.createdbyuserid = createdbyuserid;
	}

	public Timestamp getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}

}